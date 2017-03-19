package com.starwars.model;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "filmTitleWithOpening", types = Film.class)
public interface FilmTitleWithOpening {
    String getTitle();
    String getOpeningCrawl();
}
