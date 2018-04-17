package com.starwars.usecase.planet;

import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class DeletePlanet {
    private final PlanetRepository planetRepository;

    public void execute(Long idPlanet) throws NullPointerException{
        notNull(idPlanet, "Planet id cannot be null");

        planetRepository.deleteById(idPlanet);
    }
}
