package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SavePlanet {
    private final PlanetRepository planetRepository;

    public Planet execute(Planet planet) throws NullPointerException{
        Planet result;

        if (planet != null){
            result = planetRepository.save(planet);
        } else {
            throw new NullPointerException("Planet is null");
        }

        return result;
    }
}
