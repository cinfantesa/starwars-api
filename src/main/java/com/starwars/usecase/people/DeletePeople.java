package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePeople {
    @Autowired
    private PeopleRepository peopleRepository;

    public void execute(Long idPeople) throws Exception{
        if (idPeople != null){
            peopleRepository.delete(idPeople);
        } else {
            throw new Exception("People is null");
        }
    }
}
