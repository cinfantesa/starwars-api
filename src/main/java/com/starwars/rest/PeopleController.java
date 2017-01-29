package com.starwars.rest;

import com.starwars.model.People;
import com.starwars.usecase.people.DeletePeople;
import com.starwars.usecase.people.FindAllPeople;
import com.starwars.usecase.people.FindPeople;
import com.starwars.usecase.people.SavePeople;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<People>> findAll() {
        ResponseEntity<List<People>> result;

        List<People> people = findAllPeople.execute();
        result = new ResponseEntity<List<People>>(people, HttpStatus.OK);

        return result;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<People> save(@RequestBody People people) {
        ResponseEntity<People> result;

        People saved = savePeople.execute(people);
        result = new ResponseEntity<People>(saved,HttpStatus.CREATED);

        return result;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<People> findById(@PathVariable Long id) {
        ResponseEntity<People> result;

        People found = findPeople.execute(id);
        result = new ResponseEntity<People>(found,HttpStatus.OK);

        return result;
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
