package com.astroviking.pawpals.mappers;

import com.astroviking.pawpals.domain.UserProfile;
import com.astroviking.pawpals.dto.UserProfileDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserProfileMapperTest {

  UserProfileMapper mapper = new UserProfileMapper();

  @Test
  void mapToDTO() {

    UserProfile entity = new UserProfile();
    entity.setId("id");
    entity.setFirstName("first");
    entity.setLastName("last");
    entity.setEmail("email");

    UserProfileDTO dto = mapper.mapToDTO(entity);

    assertNotNull(dto);

    assertEquals(entity.getFirstName(), dto.getFirstName());
    assertEquals(entity.getLastName(), dto.getLastName());
    assertEquals(entity.getEmail(), dto.getEmail());
  }

  @Test
  void mapToEntity() {
    UserProfileDTO dto = new UserProfileDTO();
    dto.setFirstName("first");
    dto.setLastName("last");
    dto.setEmail("email");

    UserProfile entity = mapper.mapToEntity(dto);

    assertNotNull(entity);

    assertNull(entity.getId());
    assertEquals(dto.getFirstName(), entity.getFirstName());
    assertEquals(dto.getLastName(), entity.getLastName());
    assertEquals(dto.getEmail(), entity.getEmail());
  }
}
