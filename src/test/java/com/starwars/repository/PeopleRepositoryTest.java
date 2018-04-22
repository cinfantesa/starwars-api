package com.starwars.repository;

import com.starwars.model.People;
import com.starwars.model.PeopleOnlyName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PeopleRepositoryTest {
    @Autowired
    private PeopleRepository repository;

    @Test
    public void should_return_only_people_with_red_or_yellow_eyes() {
        List<People> foundPeople = repository.findPeopleWithEyesColor("yellow");

        assertFalse(foundPeople.isEmpty());
        assertThat(foundPeople.size(), is(1));
    }

    @Test
    public void should_return_people_names() {
        List<PeopleOnlyName> peopleNames = repository.findFirst20ByOrderByMassDesc();

        assertFalse(peopleNames.isEmpty());
    }
}
