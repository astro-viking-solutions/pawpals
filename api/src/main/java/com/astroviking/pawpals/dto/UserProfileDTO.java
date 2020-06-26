package com.astroviking.pawpals.dto;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class UserProfileDTO {
  @JMap
  private String firstName;
  @JMap
  private String lastName;
  @JMap
  private String email;
}
