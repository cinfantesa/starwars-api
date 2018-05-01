package com.starwars.rest;

import com.starwars.model.Planet;
import com.starwars.repository.PlanetRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RepositoryRestController
@AllArgsConstructor
public class PlanetController {
    private final PlanetRepository planetRepository;

    @RequestMapping(method = GET, value = "planets/search/findTop10ByOrderByPopulationAsc")
    public @ResponseBody ResponseEntity<?> withGoogleLinks() {
        List<Planet> top10ByOrderByPopulationAsc = planetRepository.findTop10ByOrderByPopulationAsc();

        Resources<Planet> resources = new Resources<>(top10ByOrderByPopulationAsc);
        resources.forEach(resource -> resource.add(new Link("www.google.es").withRel("google")));

        return ResponseEntity.ok(resources);
    }
}
