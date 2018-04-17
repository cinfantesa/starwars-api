package com.starwars.usecase.film;

import com.starwars.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class DeleteFilm {
    private final FilmRepository filmRepository;

    public void execute(Long idFilm) throws NullPointerException {
        notNull(idFilm, "Film id cannot be null");
        filmRepository.deleteById(idFilm);
    }
}
