package com.starwars.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FakeAuthenticationProvider implements AuthenticationProvider{

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String name = authentication.getName();
    String pass = authentication.getCredentials().toString();
    if (name.equals(pass)) {
      return new UsernamePasswordAuthenticationToken(name, pass, new ArrayList<>());
    }

    throw new BadCredentialsException("Incorrect Password");
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
  }
}
