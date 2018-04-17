package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class FindFilm {
    private final FilmRepository filmRepository;

    public Film execute(Long idFilm) throws NullPointerException {
        notNull(idFilm, "Film id cannot be null");
        return filmRepository.findById(idFilm)
            .orElseThrow(NullPointerException::new);
    }
}
