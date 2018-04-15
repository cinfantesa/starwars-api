package com.starwars.rest;

import com.starwars.model.People;
import com.starwars.usecase.people.DeletePeople;
import com.starwars.usecase.people.FindAllPeople;
import com.starwars.usecase.people.FindPeople;
import com.starwars.usecase.people.SavePeople;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/people")
public class PeopleController {
    private final SavePeople savePeople;
    private final FindAllPeople findAllPeople;
    private final FindPeople findPeople;
    private final DeletePeople deletePeople;

    @RequestMapping(method = GET)
    public List<People> findAll() {
        return findAllPeople.execute();
    }

    @RequestMapping(method = POST)
    public People save(@RequestBody People people) {
        return savePeople.execute(people);
    }

    @RequestMapping(path = "/{id}", method = GET)
    public People findById(@PathVariable Long id) {
        return findPeople.execute(id);
    }

    @RequestMapping(path = "/{id}", method = PUT)
    public void update(@PathVariable Long id, @RequestBody People people){
        People found = findPeople.execute(id);
        if (found != null){
            savePeople.execute(people);
        }
    }

    @RequestMapping(path = "/{id}", method = DELETE)
    public void delete(@PathVariable Long id) {
        deletePeople.execute(id);
    }
}
