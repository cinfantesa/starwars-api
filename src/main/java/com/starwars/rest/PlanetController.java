package com.starwars.rest;

import com.starwars.model.Planet;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@AllArgsConstructor
@ExposesResourceFor(Planet.class)
@RequestMapping(path = "/planets")
public class PlanetController {
    private final SavePlanet savePlanet;
    private final FindPlanet findPlanet;
    private final FindAllPlanets findAllPlanets;
    private final DeletePlanet deletePlanet;

    @RequestMapping(method = GET)
    public List<Planet> findAll() {
        List<Planet> planets = findAllPlanets.execute();
        planets.forEach((planet -> {
            Link selfLink = linkTo(methodOn(PlanetController.class).findById(planet.getPlanetId())).withSelfRel();
            planet.add(selfLink);
        }));

        return planets;
    }

    @RequestMapping(method = POST)
    public Planet save(@RequestBody Planet planet) {
        return savePlanet.execute(planet);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public Planet findById(@PathVariable("id") Long id){
        return findPlanet.execute(id);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    public void update(@PathVariable("id") Long id, @RequestBody Planet planet){
        Planet found = findPlanet.execute(id);
        if (found != null){
            savePlanet.execute(planet);
        }
    }

    @RequestMapping(path = "/{id}", method = DELETE)
    public void delete(@PathVariable Long id){
        deletePlanet.execute(id);
    }
}
