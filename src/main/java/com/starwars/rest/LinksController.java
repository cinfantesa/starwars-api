package com.starwars.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/links")
public class LinksController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResourceSupport> findAll(){
        ResponseEntity<ResourceSupport> result;
        ResourceSupport resource = new ResourceSupport();

        Link swapiLink = new Link("http://swapi.com");
        Link filmsLink = linkTo(FilmController.class).withRel("films");
        Link peopleLink = linkTo(PeopleController.class).withRel("people");
        Link planetsLink = linkTo(PlanetController.class).withRel("planets");

        resource.add(swapiLink);
        resource.add(filmsLink);
        resource.add(peopleLink);
        resource.add(planetsLink);

        result = new ResponseEntity<ResourceSupport>(resource, HttpStatus.OK);

        return result;
    }
}