package com.starwars.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Account {
  @Id
  private String id;
  private String username;
  private String password;
}
