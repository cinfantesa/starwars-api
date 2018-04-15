package com.starwars.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@RestController
@RequestMapping(path = "/links")
public class LinksController {

    @RequestMapping(method = RequestMethod.GET)
    public ResourceSupport findAll(){
        ResourceSupport resource = new ResourceSupport();

        Link swapiLink = new Link("http://swapi.com");
        Link filmsLink = linkTo(FilmController.class).withRel("films");
        Link peopleLink = linkTo(PeopleController.class).withRel("people");
        Link planetsLink = linkTo(PlanetController.class).withRel("planets");

        resource.add(swapiLink);
        resource.add(filmsLink);
        resource.add(peopleLink);
        resource.add(planetsLink);

        return resource;
    }
}