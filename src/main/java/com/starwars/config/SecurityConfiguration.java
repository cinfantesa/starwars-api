package com.starwars.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final FakeAuthenticationProvider fakeAuthenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(fakeAuthenticationProvider);
    }
}
