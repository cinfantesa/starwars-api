package com.starwars.listener;

import com.starwars.model.Film;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
@Slf4j
public class FimsEventHandler {

    @HandleBeforeSave
    public void handleBeforeSave(Film film){
        log.info("Before save {}", film);
    }

    @HandleAfterSave
    public void handleAfterSave(Film film){
        log.info("After save {}", film);
    }
}

