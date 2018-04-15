package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindPlanet {
    private final PlanetRepository planetRepository;

    public Planet execute(Long idPlanet) throws NullPointerException{
        Planet result = null;

        if (idPlanet != null){
            result = planetRepository.findById(idPlanet)
                .orElseThrow(NullPointerException::new);
        }

        return result;
    }
}
