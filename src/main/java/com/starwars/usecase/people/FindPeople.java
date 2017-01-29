package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindPeople {
    @Autowired
    private PeopleRepository peopleRepository;

    public People execute(Long idPeople) throws NullPointerException {
        People result = null;

        if (idPeople != null){
            result = peopleRepository.findOne(idPeople);
        } else {
            throw new NullPointerException("People id is null");
        }

        return result;
    }
}
