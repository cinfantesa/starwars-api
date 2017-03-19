package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "planetOnlyNameAndPopulation", types = Planet.class)
public interface PlanetOnlyNameAndPopulation {
    String getName();
    Long getPopulation();
}
