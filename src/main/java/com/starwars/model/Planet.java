package com.starwars.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EntityListeners({AuditingEntityListener.class})
public class Planet extends ResourceSupport{
    @Id
    @GeneratedValue
    private Long planetId;

    private String name;
    private Integer rotationPeriod;
    private Integer orbitalPeriod;
    private Integer diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private Integer surfaceWater;
    private Long population;
}
