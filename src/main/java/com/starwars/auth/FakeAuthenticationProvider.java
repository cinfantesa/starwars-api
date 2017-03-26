package com.starwars.auth;

import com.starwars.model.Account;
import com.starwars.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FakeAuthenticationProvider implements AuthenticationProvider{
  private AccountRepository accountRepository;

  @Autowired
  public FakeAuthenticationProvider(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    String name = authentication.getName();
    Account account = accountRepository.findByUsername(name);

    if (account == null) {
      throw new BadCredentialsException("User not exists");
    }

    if (name.equals(account.getPassword())) {
      return new UsernamePasswordAuthenticationToken(name, account.getPassword(), new ArrayList<>());
    }

    throw new BadCredentialsException("Incorrect Password");
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
  }
}
