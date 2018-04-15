package com.starwars.usecase.people;

import com.starwars.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeletePeople {
    private PeopleRepository peopleRepository;

    public void execute(Long idPeople) throws NullPointerException{
        if (idPeople != null){
            peopleRepository.deleteById(idPeople);
        } else {
            throw new NullPointerException("People is null");
        }
    }
}
