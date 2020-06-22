package com.astroviking.pawpals.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class GeoState {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String abbreviation;
  private String name;

  public GeoState(String abbreviation, String name) {
    this.abbreviation = abbreviation;
    this.name = name;
  }
}
