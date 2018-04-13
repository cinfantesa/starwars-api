package com.starwars.model;

import org.springframework.data.jpa.domain.Specification;

public class PeopleSpecifications {
    public static Specification<People> hasRedEyes() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("eyeColor"), "red");
    }

    public static Specification<People> hasYellowEyes() {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("eyeColor"), "yellow");
    }
}
