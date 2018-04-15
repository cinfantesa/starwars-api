package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllPlanets {
    private final PlanetRepository planetRepository;

    public List<Planet> execute() {
        return planetRepository.findAll();
    }
}
