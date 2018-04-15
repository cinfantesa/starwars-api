package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class FindAllPeople {
    private PeopleRepository peopleRepository;

    public List<People> execute() {
        return peopleRepository.findAll();
    }
}
