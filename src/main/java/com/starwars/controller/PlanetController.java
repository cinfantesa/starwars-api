package com.starwars.controller;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RepositoryRestController
public class PlanetController {
    private PlanetRepository planetRepository;

    @Autowired
    public PlanetController(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "planets/search/findAllByOrderByNameDesc")
    public @ResponseBody ResponseEntity<?> withGoogleLink() {
        List<Planet> planets = planetRepository.findAllByOrderByNameDesc();

        Resources<Planet> resources = new Resources<Planet>(planets);
        resources.forEach(resource -> resource.add(new Link("www.google.es").withRel("google")));

        return ResponseEntity.ok(resources);
    }
}
