package com.astroviking.pawpals.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Species {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(unique = true)
  private String name;

}
