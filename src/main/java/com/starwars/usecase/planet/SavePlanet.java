package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePlanet {
    @Autowired
    private PlanetRepository planetRepository;

    public Planet execute(Planet planet) throws NullPointerException{
        Planet result = null;

        if (planet != null){
            result = planetRepository.save(planet);
        } else {
            throw new NullPointerException("Planet is null");
        }

        return result;
    }
}
