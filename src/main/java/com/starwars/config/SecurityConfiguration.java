package com.starwars.config;

import com.starwars.auth.FakeAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  private FakeAuthenticationProvider authenticationProvider;

  @Autowired
  public SecurityConfiguration(FakeAuthenticationProvider authenticationProvider) {
    super();
    this.authenticationProvider = authenticationProvider;
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authenticationProvider);
  }
}
