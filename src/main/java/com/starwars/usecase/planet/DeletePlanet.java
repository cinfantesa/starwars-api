package com.starwars.usecase.planet;

import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePlanet {
    private final PlanetRepository planetRepository;

    public void execute(Long idPlanet) throws NullPointerException{
        if (idPlanet != null){
            planetRepository.deleteById(idPlanet);
        } else {
            throw new NullPointerException("Planet is null");
        }
    }
}
