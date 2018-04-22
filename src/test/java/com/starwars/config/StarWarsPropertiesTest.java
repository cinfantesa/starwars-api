package com.starwars.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class StarWarsPropertiesTest {
    @Autowired
    private StarWarsProperties starWarsProperties;

    @Test
    public void name() {
      log.info(starWarsProperties.toString());
    }
}
