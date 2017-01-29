package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SavePeople {
    @Autowired
    private PeopleRepository peopleRepository;

    public People execute(People people) throws Exception{
        People result = null;

        if (people != null){
            result = peopleRepository.save(people);
        } else {
            throw new Exception("People is null");
        }

        return result;
    }
}
