package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindFilm {
    private final FilmRepository filmRepository;

    public Film execute(Long idFilm) throws NullPointerException {
        Film result = null;

        if (idFilm != null){
           result = filmRepository.findById(idFilm)
            .orElseThrow(NullPointerException::new);
        }

        return result;
    }
}
