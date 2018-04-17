package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class SavePlanet {
    private final PlanetRepository planetRepository;

    public Planet execute(Planet planet) throws NullPointerException{
        notNull(planet, "Planet id cannot be null");
        return planetRepository.save(planet);
        }
}
