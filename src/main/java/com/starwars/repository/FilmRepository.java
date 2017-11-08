package com.starwars.repository;

import com.starwars.model.Film;
import com.starwars.model.FilmTitleWithOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static javafx.scene.input.KeyCode.T;

@RepositoryRestResource()
public interface FilmRepository extends JpaRepository<Film,Long>, CustomFilmRepository{
    List<Film> findAllByOrderByEpisodeIdAsc();

    List<Film> findAllByReleaseDateGreaterThanEqual(@Param("releaseDate") Date releaseDate);

    @Query("select f from Film f where f.people.size = (select max(f2.people.size) from Film f2)")
    List<Film> fillAllByMaxPeople();

    @Query("select f from Film f where f.planets.size = (select min(f2.planets.size) from Film f2)")
    List<Film> fillAllByMinPlanets();

    @Query("select f from Film f join f.people p where p.name = :name")
    List<Film> findAllByPeopleContains(@Param("name") String name);


    @Override
    @RestResource(exported = false)
    void flush();

    @Override
    @RestResource(exported = false)
    void deleteInBatch(Iterable<Film> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();

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
