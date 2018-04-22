package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.usecase.film.DeleteFilm;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.film.FindFilm;
import com.starwars.usecase.film.SaveFilm;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Consumer;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/films")
public class FilmController {
    private final SaveFilm saveFilm;
    private final FindAllFilm findAllFilm;
    private final FindFilm findFilm;
    private final DeleteFilm deleteFilm;

    private final EntityLinks entityLinks;

    @RequestMapping(method = GET)
    public List<Film> findAll() {
        List<Film> films = findAllFilm.execute();

        films.forEach(addLinks());

        return films;
    }

    @RequestMapping(method = POST)
    public Film save(@RequestBody Film Film) {
        return saveFilm.execute(Film);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Film findById(@PathVariable Long id) {
        Film film = findFilm.execute(id);
        film.add(new Link("www.google.es"));

        film.getPlanets()
            .forEach(planet -> planet.add(entityLinks.linkToSingleResource(Planet.class, planet.getId())));

        return film;
    }

    @RequestMapping(path = "/{id}", method = PUT)
    public void update(@PathVariable Long id, @RequestBody Film Film){
        Film found = findFilm.execute(id);
        if (found != null){
            saveFilm.execute(Film);
        }
    }

    @RequestMapping(path = "/{id}", method = DELETE)
    public void delete(@PathVariable Long id) {
        deleteFilm.execute(id);
    }

    private Consumer<Film> addLinks() {
        return (Film f) -> {
            f.getPlanets().forEach(addLinkToPlanet());

            f.getPeople().forEach(addLinkToPeople());

            f.add(linkTo(PlanetController.class).withRel("planets"));
        };
    }

    private Consumer<People> addLinkToPeople() {
        return (People p) -> {
            if (!p.hasLink("self")) {
                Link linkTo = linkTo(methodOn(PeopleController.class).findById(p.getPeopleId())).withSelfRel();
                p.add(linkTo);
            }
        };
    }

    private Consumer<Planet> addLinkToPlanet() {
        return (Planet p) -> {
            if (!p.hasLink("self")) {
                Link linkTo = linkTo(methodOn(PlanetController.class).findById(p.getPlanetId())).withSelfRel();
                p.add(linkTo);
            }
        };
    }
}
