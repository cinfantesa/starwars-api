package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.usecase.film.DeleteFilm;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.film.FindFilm;
import com.starwars.usecase.film.SaveFilm;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/films")
public class FilmController {
    private final SaveFilm saveFilm;
    private final FindAllFilm findAllFilm;
    private final FindFilm findFilm;
    private final DeleteFilm deleteFilm;

    @RequestMapping(method = GET)
    public List<Film> findAll() {
        List<Film> films = findAllFilm.execute();

        films.forEach((Film f) -> {
            f.getPlanets().forEach((Planet p) -> {
                if (!p.hasLink("self")) {
                    Link linkTo = linkTo(methodOn(PlanetController.class).findById(p.getPlanetId())).withRel("self");
                    p.add(linkTo);
                }
            });

            f.getPeople().forEach((People p) -> {
                if (!p.hasLink("self")) {
                    Link linkTo = linkTo(methodOn(PeopleController.class).findById(p.getPeopleId())).withRel("self");
                    p.add(linkTo);
                }
            });

            Link deleteLink = linkTo(FilmController.class).slash(f.getFilmId()).withRel("delete");
            f.add(deleteLink);
        });

        return films;
    }

    @RequestMapping(method = POST)
    public Film save(@RequestBody Film Film) {
        return saveFilm.execute(Film);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Film findById(@PathVariable Long id) {
        return findFilm.execute(id);
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
}
