package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.model.People;
import com.starwars.model.Planet;
import com.starwars.repository.FilmRepository;
import com.starwars.repository.PeopleRepository;
import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class SaveFilm {
    private FilmRepository filmRepository;
    private PlanetRepository planetRepository;
    private PeopleRepository peopleRepository;

    public Film execute(Film film) throws NullPointerException {
        notNull(film, "Film id cannot be null");
        createPlanetsWhenNotExists(film.getPlanets());
        createPeopleWhenNotExists(film.getPeople());
        return filmRepository.save(film);
    }

    private void createPlanetsWhenNotExists(List<Planet> planets) {
        planets.forEach((Planet p) -> {
            if (!planetRepository.existsById(p.getPlanetId())){
                planetRepository.save(p);
            }
        });
    }

    private void createPeopleWhenNotExists(List<People> people) {
        people.forEach((People p) -> {
            if (!peopleRepository.existsById(p.getPeopleId())){
                peopleRepository.save(p);
            }
        });
    }
}
