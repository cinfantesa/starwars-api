package com.starwars.repository;

import com.starwars.model.Film;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilmRepositoryImpl implements CustomFilmRepository {
    @Override
    public void logFilm(Film film) {
      log.info(film.toString());
    }
}
