package com.starwars.controller;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RepositoryRestController
public class FilmController {
    private FilmRepository filmRepository;
    private static HashMap<Integer,Link> imdbLinks;

    @Autowired
    public FilmController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
        loadImdbLinks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "films/search/findAllByReleaseDateGreaterThanEqual")
    public @ResponseBody ResponseEntity withImdbLink(@RequestParam("releaseDate") @DateTimeFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss") Date releaseDate){
        List<Film> films = filmRepository.findAllByReleaseDateGreaterThanEqual(releaseDate);

        Resources<Film> resources = new Resources<>(films);
        resources.forEach(resource -> resource.add(imdbLinks.get(resource.getEpisodeId()).withRel("imdb")));

        return ResponseEntity.ok(resources);
    }

    private static void loadImdbLinks(){
        imdbLinks = new HashMap<>();

        imdbLinks.put(1, new Link("http://www.imdb.com/title/tt0120915/?ref_=fn_ft_tt_5"));
        imdbLinks.put(2, new Link("http://www.imdb.com/title/tt0121765/?ref_=fn_ft_tt_12"));
        imdbLinks.put(3, new Link("http://www.imdb.com/title/tt0121766/?ref_=fn_ft_tt_9"));
        imdbLinks.put(4, new Link("http://www.imdb.com/title/tt0076759/?ref_=fn_ft_tt_1"));
        imdbLinks.put(5, new Link("http://www.imdb.com/title/tt0080684/?ref_=fn_ft_tt_11"));
        imdbLinks.put(6, new Link("http://www.imdb.com/title/tt0086190/?ref_=fn_ft_tt_10"));
        imdbLinks.put(7, new Link("http://www.imdb.com/title/tt2488496/?ref_=fn_ft_tt_4"));
    }
}
