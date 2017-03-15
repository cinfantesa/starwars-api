package com.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class StarwarsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarwarsApiApplication.class, args);
	}
}
