package com.starwars.repository;

import com.starwars.model.Film;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FilmRepositoryTest {

    @Autowired
    private FilmRepository filmRepository;

    @Test
    public void should_do_films_pagination() throws Exception {
        int pageNumber = 0;
        int pageSize = 2;
        PageRequest pageRequest = new PageRequest(pageNumber,pageSize);
        Page<Film> filmPage = filmRepository.findAll(pageRequest);
    }

    @Test
    public void should_find_all_sorting_by_episode() throws Exception {

        Sort sort = new Sort(Sort.Direction.ASC,"episodeId")
                .and(new Sort(Sort.Direction.DESC,"releaseDate"));

        List<Film> sorted = filmRepository.findAll(new Sort(Sort.Direction.ASC,"episodeId"));
        Assert.assertTrue(sorted.get(0).getEpisodeId() == 7);
        Assert.assertTrue(sorted.get(sorted.size()-1).getEpisodeId() == 1);
    }

    @Test
    public void should_find_all_films_released_after_date() throws Exception {
        String inputString = "2000/01/01";
        DateFormat dateFormat = new SimpleDateFormat("YYYY/MM/DD");
        Date inputDate = dateFormat.parse(inputString);

        List<Film> films = filmRepository.findAllByReleaseDateGreaterThanEqual(inputDate);
        Assert.assertNotNull(films);
    }

    @Test
    public void should_find_most_people_films() throws Exception {
        List<Film> films = filmRepository.findAllByMaxPeople();
        Assert.assertNotNull(films);
    }

    @Test
    public void should_find_less_planets_films() throws Exception {
        List<Film> films = filmRepository.findAllByMinPlanets();
        Assert.assertNotNull(films);
    }

    @Test
    public void should_find_film_with_people() throws Exception {
        List<Film> films = filmRepository.findAllByPeopleContains("Luke Skywalker");
        Assert.assertNotNull(films);

    }

    @Test
    public void should_log_film() throws Exception {
        List<Film> all = filmRepository.findAll();
        for (Film film : all){
            filmRepository.logFilm(film);
        }
    }
}
