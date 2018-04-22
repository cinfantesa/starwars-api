package com.starwars.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "starwars")
@Data
public class StarWarsProperties {
    private Boolean enabled;
    private Integer episodes;
    private List<String> characters;
}
