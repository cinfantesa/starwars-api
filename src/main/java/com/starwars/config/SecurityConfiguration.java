package com.starwars.config;

import com.starwars.auth.FakeAuthProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;

/**
 * Created by joaquinanton on 14/7/17.
 */

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    private FakeAuthProvider fakeAuthProvider;

    public SecurityConfiguration(FakeAuthProvider fakeAuthProvider){
        this.fakeAuthProvider = fakeAuthProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("password").roles("ADMIN");
        auth.authenticationProvider(fakeAuthProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/films**").permitAll()
                .antMatchers("/planets**").hasRole("ADMIN")
                .antMatchers("/persons**").authenticated();
    }
}
