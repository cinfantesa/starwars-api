package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "peopleWithNoPersonalInfo", types = People.class)
public interface PeopleWithNoPersonalInfo {
    String getName();
    String getBirthYear();
}
