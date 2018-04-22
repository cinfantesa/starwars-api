package com.starwars.repository;

import com.starwars.model.People;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.List;

import static com.starwars.model.PeopleSpecifications.hasEyesColor;
import static com.starwars.model.PeopleSpecifications.hasRedEyes;
import static com.starwars.model.PeopleSpecifications.hasYellowEyes;
import static org.springframework.data.jpa.domain.Specification.where;

@Slf4j
@AllArgsConstructor
public class PeopleRepositoryImpl implements CustomPeopleRepository {
    private final EntityManager entityManager;

    @Override
    public List<People> findPeopleWithEyesColor(String color) {
        Specification<People> specs = where(hasEyesColor(color));

        CriteriaQuery<People> query = entityManager.getCriteriaBuilder().createQuery(People.class);
        Root<People> root = query.from(People.class);
        query.where(specs.toPredicate(root, query, entityManager.getCriteriaBuilder()));

        return entityManager.createQuery(query).getResultList();
    }
}
