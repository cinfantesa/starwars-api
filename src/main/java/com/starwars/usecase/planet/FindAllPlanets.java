package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllPlanets {
    @Autowired
    private PlanetRepository planetRepository;

    public List<Planet> execute() {
        List<Planet> result = null;

        result = planetRepository.findAll();

        return result;
    }
}
