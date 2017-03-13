package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindFilm {

    @Autowired
    private FilmRepository filmRepository;

    public Film execute(Long idFilm) throws NullPointerException {
        Film result = null;

        if (idFilm != null){
           result = filmRepository.findOne(idFilm);
        } else {
            throw new NullPointerException("Film is null");
        }

        return result;
    }
}
