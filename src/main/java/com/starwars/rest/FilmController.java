package com.starwars.rest;

import com.starwars.model.Film;
import com.starwars.model.Planet;
import com.starwars.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joaquinanton on 14/7/17.
 */

@RepositoryRestController
public class FilmController {

    private FilmRepository filmRepository;
    private static Map<Integer, Link> imdbLinks;
    public FilmController(FilmRepository filmRepository){
        this.filmRepository = filmRepository;
        this.loadImdbLinks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "films/search/findAllByReleaseDateGreaterThanEqual")
    public @ResponseBody ResponseEntity withImdbLink(@RequestParam("releaseDate") @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm") Date date){

        List<Film> films = filmRepository.findAllByReleaseDateGreaterThanEqual(date);

        Resources<Film> resources = new Resources<>(films);
        resources.forEach(resource -> resource.add(imdbLinks.get(resource.getEpisodeId()).withRel("imdb")));
        return ResponseEntity.ok(resources);
    }

    private static void loadImdbLinks() {

        imdbLinks = new HashMap<>();

        imdbLinks.put(1, new Link("http://www.imdb.com/title/tt0120915/"));
        imdbLinks.put(2, new Link("http://www.imdb.com/title/tt0121765/"));
        imdbLinks.put(3, new Link("http://www.imdb.com/title/tt0121766/"));
        imdbLinks.put(4, new Link("http://www.imdb.com/title/tt0076759/"));
        imdbLinks.put(5, new Link("http://www.imdb.com/title/tt0080684/"));
        imdbLinks.put(6, new Link("http://www.imdb.com/title/tt0086190/"));
        imdbLinks.put(7, new Link("http://www.imdb.com/title/tt2488496/"));
    }
}
