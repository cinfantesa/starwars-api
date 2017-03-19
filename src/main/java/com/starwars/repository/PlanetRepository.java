package com.starwars.repository;

import com.starwars.model.Planet;
import com.starwars.model.PlanetOnlyNameAndPopulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PlanetOnlyNameAndPopulation.class)
public interface PlanetRepository extends JpaRepository<Planet,Long>{
    Planet findByName(String name);
    List<Planet> findByNameContaining(@Param("name") String name);
    List<Planet> findAllByOrderByNameDesc();
    List<Planet> findByPopulationGreaterThan(Long population);
    List<Planet> findByPopulationBetween(Long min, Long max);
    List<Planet> findTop10ByOrderByPopulationAsc();
    List<Planet> findTop10ByOrderByPopulationDesc();
}
