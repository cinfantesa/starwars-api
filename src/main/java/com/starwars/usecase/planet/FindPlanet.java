package com.starwars.usecase.planet;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindPlanet {
    @Autowired
    private PlanetRepository planetRepository;

    public Planet execute(Long idPlanet) throws Exception{
        Planet result = null;

        if (idPlanet != null){
            result = planetRepository.findOne(idPlanet);
        } else {
            throw new Exception("Planet id is null");
        }

        return result;
    }
}
