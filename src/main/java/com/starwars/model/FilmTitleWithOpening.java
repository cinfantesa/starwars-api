package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

import java.util.List;

/**
 * Created by joaquinanton on 14/7/17.
 */

@Projection(name="filmTitleWithOpening", types = Film.class)
public interface FilmTitleWithOpening {
    String getTitle();
    String getOpeningCrawl();
    List<PeopleWithNoPersonalInfo> getPeople();
}
