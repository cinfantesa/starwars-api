package com.starwars.repository;

import com.starwars.model.People;
import com.starwars.model.PeopleOnlyName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource(excerptProjection = PeopleOnlyName.class)
public interface PeopleRepository extends JpaRepository<People,Long>, CustomPeopleRepository{
    People findByNameIgnoreCase(String name);
    List<People> findByHeightGreaterThanEqual(Integer height);
    List<People> findByEyeColorIn(Collection<String> eyeColors);
    List<PeopleOnlyName> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorInOrderByNameAsc(Collection<String> eyeColors);

//    @Query("select p from People p where p.name like 'S%'")

    @Query(value = "select * from People where name like 'S%'", nativeQuery = true)
    List<People> findByNameStartingWith(String name);
}
