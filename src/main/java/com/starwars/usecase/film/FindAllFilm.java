package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllFilm {
    private final FilmRepository filmRepository;

    public List<Film> execute() {
        return filmRepository.findAll();
    }
}
