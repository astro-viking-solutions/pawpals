package com.astroviking.pawpals.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserProfile {
  @Id
  private String id;
  private String firstName;
  private String lastName;
  private String email;
}
