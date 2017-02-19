package com.starwars.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.usecase.film.DeleteFilm;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.film.FindFilm;
import com.starwars.usecase.film.SaveFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.xml.ws.Response;
import java.util.List;

//@Controller
@RequestMapping(path = "/films")
public class FilmController {

    @Autowired
    private SaveFilm saveFilm;

    @Autowired
    private FindAllFilm findAllFilm;

    @Autowired
    private FindFilm findFilm;

    @Autowired
    private DeleteFilm deleteFilm;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Film>> findAll() {
        ResponseEntity<List<Film>> result;

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

        result = new ResponseEntity<List<Film>>(films, HttpStatus.OK);

        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Film> save(@RequestBody Film Film) {
        ResponseEntity<Film> result;

        Film saved = saveFilm.execute(Film);
        result = new ResponseEntity<com.starwars.model.Film>(saved,HttpStatus.CREATED);

        return result;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Film> findById(@PathVariable Long id) {
        ResponseEntity<Film> result;

        Film found = findFilm.execute(id);
        result = new ResponseEntity<Film>(found,HttpStatus.OK);

        return result;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Film Film){
        Film found = findFilm.execute(id);
        if (found != null){
            saveFilm.execute(Film);
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        deleteFilm.execute(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
