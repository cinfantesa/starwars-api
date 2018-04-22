package com.starwars.repository;

import com.starwars.model.People;

import java.util.List;

public interface CustomPeopleRepository {
    List<People> findPeopleWithEyesColor(String color);
}
