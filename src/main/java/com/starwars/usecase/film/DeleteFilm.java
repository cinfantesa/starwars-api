package com.starwars.usecase.film;

import com.starwars.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteFilm {

    @Autowired
    private FilmRepository filmRepository;

    public void execute(Long idFilm) throws NullPointerException {

        if (idFilm != null){
            filmRepository.delete(idFilm);
        } else {
            throw new NullPointerException("Film is null");
        }
    }
}
