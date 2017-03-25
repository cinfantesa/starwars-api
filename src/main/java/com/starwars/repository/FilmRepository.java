package com.starwars.repository;

import com.starwars.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>, CustomFilmRepository{

    List<Film> findAllByReleaseDateGreaterThanEqual(Date releaseDate);

    @Query("select f from Film f where f.people.size = (select max(f2.people.size) from Film f2)")
    List<Film> findAllByMaxPeople();

    @Query("select f from Film f where f.people.size = (select min(f2.people.size) from Film f2)")
    List<Film> findAllByMinPlanets();

    @Query("select f from Film f join f.people p where p.name=:name")
    List<Film> findAllByPeopleContains(@Param("name") String name);

    @Override
    @RestResource(exported = false)
    Film saveAndFlush(Film film);

    @Override
    @RestResource(exported = false)
    void deleteInBatch(Iterable<Film> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();

    @Override
    @RestResource(exported = false)
    Film save(Film film);

    @Override
    @RestResource(exported = false)
    void delete(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(Film film);

    @Override
    @RestResource(exported = false)
    void delete(Iterable<? extends Film> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
