package com.starwars.repository;

import com.starwars.model.Planet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTest {
    
    @Autowired
    private PlanetRepository planetRepository;

    @Test
    public void should_find_by_name() throws Exception {
        Planet alderaan = planetRepository.findByName("Alderaan");
        Assert.assertTrue(alderaan.getName().equals("Alderaan"));
    }

    @Test
    public void should_find_planet_name_containing() throws Exception {
        List<Planet> byNameContaining = planetRepository.findByNameContaining("o");
        Assert.assertEquals(3,byNameContaining.size());
    }

    @Test
    public void should_get_planets_ordered() throws Exception {
        List<Planet> planets = planetRepository.findAllByOrderByNameDesc();
        Assert.assertTrue(planets.get(0).getName().equals("Yavin IV"));
        Assert.assertTrue(planets.get(5).getName().equals("Alderaan"));
    }

    @Test
    public void should_find_by_population_greater_than() throws Exception {
        List<Planet> planets = planetRepository.findByPopulationGreaterThan(Long.valueOf(5000));
        Assert.assertEquals(3, planets.size());
    }
}
