package com.starwars.usecase.people;

import com.starwars.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class DeletePeople {
    private PeopleRepository peopleRepository;

    public void execute(Long idPeople) throws NullPointerException{
        notNull(idPeople, "People id cannot be null");
        peopleRepository.deleteById(idPeople);
    }
}
