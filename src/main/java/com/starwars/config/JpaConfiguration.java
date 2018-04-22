package com.starwars.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.hateoas.config.EnableEntityLinks;

@Configuration
@EnableJpaAuditing
@EnableEntityLinks
public class JpaConfiguration {
}
