package com.starwars.auth;

import com.starwars.model.Account;
import com.starwars.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

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

    if (account == null || !authentication.getCredentials().equals(account.getPassword())) {
      throw new BadCredentialsException("User not exists or incorrect password");
    }

    return new UsernamePasswordAuthenticationToken(name, account.getPassword(), getGrantedAuthorities(name));
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
  }

  private Collection<? extends GrantedAuthority> getGrantedAuthorities(String username) {
    Collection<? extends GrantedAuthority> authorities;
    if ("admin".equals(username)) {
      authorities = Arrays.asList(() -> "ROLE_ADMIN", () -> "ROLE_BASIC");
    } else {
      authorities = Arrays.asList(() -> "ROLE_BASIC");
    }
    return authorities;
  }
}
