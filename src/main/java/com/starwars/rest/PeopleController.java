package com.starwars.rest;

import com.starwars.model.People;
import com.starwars.usecase.people.DeletePeople;
import com.starwars.usecase.people.FindAllPeople;
import com.starwars.usecase.people.FindPeople;
import com.starwars.usecase.people.SavePeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(path = "/people")
public class PeopleController {

    @Autowired
    private SavePeople savePeople;

    @Autowired
    private FindAllPeople findAllPeople;

    @Autowired
    private FindPeople findPeople;

    @Autowired
    private DeletePeople deletePeople;

    @RequestMapping(method = RequestMethod.GET)
    public List<People> findAll() {
        return findAllPeople.execute();
    }

    @RequestMapping(method = RequestMethod.POST)
    public People save(@RequestBody People people) {
        return savePeople.execute(people);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public People findById(@PathVariable Long id) {
        return findPeople.execute(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody People people){
        People found = findPeople.execute(id);
        if (found != null){
            savePeople.execute(people);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        deletePeople.execute(id);
    }
}
