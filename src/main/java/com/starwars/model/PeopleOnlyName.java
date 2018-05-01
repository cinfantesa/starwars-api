package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "peopleOnlyName", types = People.class)
public interface PeopleOnlyName {
    String getName();
}
