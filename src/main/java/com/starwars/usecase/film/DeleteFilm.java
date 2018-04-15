package com.starwars.usecase.film;

import com.starwars.repository.FilmRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteFilm {
    private final FilmRepository filmRepository;

    public void execute(Long idFilm) throws NullPointerException {

        if (idFilm != null){
            filmRepository.deleteById(idFilm);
        } else {
            throw new NullPointerException("Film is null");
        }
    }
}
