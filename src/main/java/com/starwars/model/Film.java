package com.starwars.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.hateoas.ResourceSupport;
import sun.misc.Resource;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"people", "planets"})
public class Film extends ResourceSupport{
    @Id
    @GeneratedValue
    private Long filmId;

    private String title;
    private Integer episodeId;
    @Column(length = 500)
    private String openingCrawl;
    private String director;
    private String producer;
    private Date releaseDate;

    @ManyToMany
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(joinColumns = {@JoinColumn(name = "film_id")},
        inverseJoinColumns = {@JoinColumn(name = "people_id")})
    private List<People> people;

    @ManyToMany
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(joinColumns = {@JoinColumn(name = "film_id")},
        inverseJoinColumns = {@JoinColumn(name = "planet_id")})
    private List<Planet> planets;
}
