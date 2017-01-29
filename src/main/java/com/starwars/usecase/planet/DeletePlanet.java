package com.starwars.usecase.planet;

import com.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePlanet {
    @Autowired
    private PlanetRepository planetRepository;

    public void execute(Long idPlanet) throws NullPointerException{
        if (idPlanet != null){
            planetRepository.delete(idPlanet);
        } else {
            throw new NullPointerException("Planet is null");
        }
    }
}
