package com.starwars.rest;

import com.starwars.model.Planet;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
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
    public List<Planet> findAll() {
        return findAllPlanets.execute();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Planet save(@RequestBody Planet planet) {
        return savePlanet.execute(planet);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Planet update(@PathVariable("id") Long id){
        return findPlanet.execute(id);
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
