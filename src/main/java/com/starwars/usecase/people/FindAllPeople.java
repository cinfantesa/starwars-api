package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllPeople {
    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> execute() throws Exception {
        List<People> result = null;

        result = peopleRepository.findAll();

        return result;
    }
}
