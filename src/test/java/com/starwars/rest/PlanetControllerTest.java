package com.starwars.rest;

import com.starwars.model.Planet;
import com.starwars.usecase.planet.DeletePlanet;
import com.starwars.usecase.planet.FindAllPlanets;
import com.starwars.usecase.planet.FindPlanet;
import com.starwars.usecase.planet.SavePlanet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Arrays.asList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PlanetController.class)
public class PlanetControllerTest {
    @MockBean
    private FindAllPlanets findAllPlanets;
    @MockBean
    private SavePlanet savePlanet;
    @MockBean
    private FindPlanet findPlanet;
    @MockBean
    private DeletePlanet deletePlanet;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_all_planets() throws Exception {
        Planet planet1 = Planet.builder().planetId(1L).name("Planet1").build();
        Planet planet2 = Planet.builder().planetId(2L).name("Planet2").build();
        Mockito.when(findAllPlanets.execute()).thenReturn(asList(planet1, planet2));

        mockMvc.perform(get("/planets/")).andDo(print()).andExpect(status().isOk());
    }
}
