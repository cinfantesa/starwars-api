package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SavePeople {
    private final PeopleRepository peopleRepository;

    public People execute(People people) throws NullPointerException{
        People result;

        if (people != null){
            result = peopleRepository.save(people);
        } else {
            throw new NullPointerException("People is null");
        }

        return result;
    }
}
