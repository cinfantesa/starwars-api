package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class SavePeople {
    private final PeopleRepository peopleRepository;

    public People execute(People people) throws NullPointerException{
        notNull(people, "People id cannot be null");
        return peopleRepository.save(people);
    }
}
