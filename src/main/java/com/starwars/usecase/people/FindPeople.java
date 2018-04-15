package com.starwars.usecase.people;

import com.starwars.model.People;
import com.starwars.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindPeople {
    private final PeopleRepository peopleRepository;

    public People execute(Long idPeople) throws NullPointerException {
        People result = null;

        if (idPeople != null){
            result = peopleRepository.findById(idPeople)
                .orElseThrow(NullPointerException::new);
        }

        return result;
    }
}
