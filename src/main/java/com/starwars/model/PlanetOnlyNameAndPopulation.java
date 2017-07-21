package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by joaquinanton on 14/7/17.
 */
@Projection(name="planetOnlyNameAndPopulation", types = Planet.class)
public interface PlanetOnlyNameAndPopulation {
    String getName();
    String getPopulation();
}
