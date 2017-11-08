package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

/**
 * Created by joaquinanton on 14/7/17.
 */

@Projection(name="peopleWithNoPersonalInfo", types = People.class)
public interface PeopleWithNoPersonalInfo {
    String getName();
    String getBirthYear();

}
