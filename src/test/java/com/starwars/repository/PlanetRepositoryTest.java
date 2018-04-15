package com.starwars.repository;

import com.starwars.model.Planet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PlanetRepositoryTest {
    
    @Autowired
    private PlanetRepository planetRepository;

    @Test
    public void should_find_by_name() {
        Planet alderaan = planetRepository.findByName("Alderaan");
        assertEquals("Alderaan", alderaan.getName());
    }

    @Test
    public void should_find_planet_name_containing() {
        List<Planet> byNameContaining = planetRepository.findByNameContaining("o");
        assertEquals(3,byNameContaining.size());
    }

    @Test
    public void should_get_planets_ordered() {
        List<Planet> planets = planetRepository.findAllByOrderByNameDesc();
        assertEquals("Yavin IV", planets.get(0).getName());
        assertEquals("Alderaan", planets.get(5).getName());
    }

    @Test
    public void should_find_by_population_greater_than() {
        List<Planet> planets = planetRepository.findByPopulationGreaterThan(5000L);
        assertEquals(3, planets.size());
    }
}
