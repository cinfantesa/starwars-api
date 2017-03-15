package com.starwars.rest;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.starwars.model.Planet;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//@Controller
@RequestMapping(path = "/planets")
public class PlanetController {

    @Autowired
    private SavePlanet savePlanet;

    @Autowired
    private FindPlanet findPlanet;

    @Autowired
    private FindAllPlanets findAllPlanets;

    @Autowired
    private DeletePlanet deletePlanet;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Planet>> findAll() {
        ResponseEntity<List<Planet>> result;

        List<Planet> planets = findAllPlanets.execute();
        planets.forEach((planet -> {
            Link selfLink = linkTo(methodOn(PlanetController.class).findById(planet.getPlanetId())).withSelfRel();
            planet.add(selfLink);
        }));

        result = new ResponseEntity<List<Planet>>(planets, HttpStatus.OK);

        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Planet> save(@RequestBody Planet planet) {
        ResponseEntity<Planet> result;

        Planet saved = savePlanet.execute(planet);
        result = new ResponseEntity<Planet>(saved,HttpStatus.CREATED);

        return result;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Planet> findById(@PathVariable("id") Long id){
        ResponseEntity<Planet> result;

        Planet updated = findPlanet.execute(id);
        result = new ResponseEntity<Planet>(updated,HttpStatus.OK);

        return result;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id, @RequestBody Planet planet){
        Planet found = findPlanet.execute(id);
        if (found != null){
            savePlanet.execute(found);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id){
        deletePlanet.execute(id);
    }
}
