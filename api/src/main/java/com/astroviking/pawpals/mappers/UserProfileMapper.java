package com.astroviking.pawpals.mappers;

import com.astroviking.pawpals.domain.UserProfile;
import com.astroviking.pawpals.dto.UserProfileDTO;
import com.googlecode.jmapper.JMapper;
import org.springframework.stereotype.Component;

@Component
public class UserProfileMapper {

  JMapper<UserProfileDTO, UserProfile> entityToDTO =
      new JMapper<>(UserProfileDTO.class, UserProfile.class);
  JMapper<UserProfile, UserProfileDTO> dtoToEntity =
      new JMapper<>(UserProfile.class, UserProfileDTO.class);

  public UserProfileDTO mapToDTO(UserProfile entity) {
    return entityToDTO.getDestination(entity);
  }
  public UserProfile mapToEntity(UserProfileDTO dto) {
    return dtoToEntity.getDestination(dto);
  }

}
