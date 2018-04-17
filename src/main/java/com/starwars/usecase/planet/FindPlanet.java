package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class FindPlanet {
    private final PlanetRepository planetRepository;

    public Planet execute(Long idPlanet) throws NullPointerException{
        notNull(idPlanet, "Planet id cannot be null");

        return planetRepository.findById(idPlanet)
            .orElseThrow(NullPointerException::new);
    }
}
