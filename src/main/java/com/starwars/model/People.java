package com.starwars.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@EntityListeners({AuditingEntityListener.class})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class People extends ResourceSupport{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long peopleId;

    @CreatedDate
    private LocalDateTime created;
    @LastModifiedDate
    private LocalDateTime edited;

    private String name;
    private String birthYear;
    private String gender;
    private String height;
    private String mass;
    private String eyeColor;
    private String hairColor;
    private String skinColor;
}
