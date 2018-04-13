package com.starwars.repository;

import com.starwars.model.People;
import com.starwars.model.PeopleSpecifications;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specifications;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.starwars.model.PeopleSpecifications.hasRedEyes;
import static com.starwars.model.PeopleSpecifications.hasYellowEyes;
import static org.springframework.data.jpa.domain.Specifications.where;

@Slf4j
@AllArgsConstructor
public class PeopleRepositoryImpl implements CustomPeopleRepository {
    private final EntityManager entityManager;

    @Override
    public List<People> findPeopleWithRedAndYellowEyesColor() {
        Specifications<People> specs = where(hasRedEyes());
        specs.and(hasYellowEyes());

        CriteriaQuery<People> query = entityManager.getCriteriaBuilder().createQuery(People.class);
        Root<People> root = query.from(People.class);
        query.where(specs.toPredicate(root, query, entityManager.getCriteriaBuilder()));

        return entityManager.createQuery(query).getResultList();
    }
}
