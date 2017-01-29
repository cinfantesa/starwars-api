package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.Film;
import com.starwars.usecase.film.DeleteFilm;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.film.FindFilm;
import com.starwars.usecase.film.SaveFilm;
import com.starwars.usecase.Film.DeleteFilm;
import com.starwars.usecase.Film.FindAllFilm;
import com.starwars.usecase.Film.FindFilm;
import com.starwars.usecase.Film.SaveFilm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
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
    public List<Film> findAll() {
        return findAllFilm.execute();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Film save(@RequestBody Film Film) {
        return saveFilm.execute(Film);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Film findById(@PathVariable Long id) {
        return findFilm.execute(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Film Film){
        Film found = findFilm.execute(id);
        if (found != null){
            saveFilm.execute(Film);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        deleteFilm.execute(id);
    }
}
