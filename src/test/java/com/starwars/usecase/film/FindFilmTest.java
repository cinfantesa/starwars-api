package com.starwars.usecase.film;

import com.starwars.model.Film;
import com.starwars.repository.FilmRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.rules.ExpectedException.none;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class FindFilmTest {
    @MockBean
    private FilmRepository filmRepository;

    private FindFilm findFilm;

    @Rule
    public ExpectedException exception = none();

    @Before
    public void setUp() {
        findFilm = new FindFilm(filmRepository);
    }

    @Test
    public void should_find_a_film() {
        when(filmRepository.findById(any())).thenReturn(Optional.of(Film.builder().build()));

        findFilm.execute(1L);

        verify(filmRepository, times(1)).findById(1L);
    }

    @Test
    public void should_throw_error_when_film_id_does_not_exists() {
        exception.expect(IllegalArgumentException.class);

        findFilm.execute(null);
    }

    @Test
    public void should_throw_error_when_film_does_not_exists() {
        when(filmRepository.findById(any())).thenReturn(empty());

        exception.expect(NullPointerException.class);

        findFilm.execute(1L);
    }
}
