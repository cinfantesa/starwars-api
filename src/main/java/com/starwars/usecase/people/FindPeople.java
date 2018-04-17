package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
@AllArgsConstructor
public class FindPeople {
    private final PeopleRepository peopleRepository;

    public People execute(Long idPeople) throws NullPointerException {
        Assert.notNull(idPeople, "People id cannot be null");
        return peopleRepository.findById(idPeople)
            .orElseThrow(NullPointerException::new);
    }
}
