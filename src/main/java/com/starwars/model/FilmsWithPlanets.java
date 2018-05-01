package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "filmWithPlanets", types = Film.class)
public interface FilmsWithPlanets {
    String getTitle();
    List<Planet> getPlanets();
}
