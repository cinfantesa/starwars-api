package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.usecase.film.DeleteFilm;
import com.starwars.usecase.film.FindAllFilm;
import com.starwars.usecase.film.FindFilm;
import com.starwars.usecase.film.SaveFilm;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
        return findAllFilm.execute();
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
