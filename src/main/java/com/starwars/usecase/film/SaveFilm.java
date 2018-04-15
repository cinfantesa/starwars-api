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

@Service
@AllArgsConstructor
public class SaveFilm {
    private FilmRepository filmRepository;
    private PlanetRepository planetRepository;
    private PeopleRepository peopleRepository;

    public Film execute(Film film) throws NullPointerException {
        Film result;

        if (film != null){
            createPlanetsWhenNotExists(film.getPlanets());
            createPeopleWhenNotExists(film.getPeople());
            result = filmRepository.save(film);
        } else {
            throw new NullPointerException("Film is null");
        }

        return result;
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
