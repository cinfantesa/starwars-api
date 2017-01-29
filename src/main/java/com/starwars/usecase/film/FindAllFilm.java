package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllFilm {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> execute() {
        List<Film> result = null;

        result = filmRepository.findAll();

        return result;
    }
}
