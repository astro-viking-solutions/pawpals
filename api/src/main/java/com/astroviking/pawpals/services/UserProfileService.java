package com.astroviking.pawpals.services;

import com.astroviking.pawpals.domain.UserProfile;
import com.astroviking.pawpals.dto.UserProfileDTO;
import com.astroviking.pawpals.exceptions.ConflictingResourceException;
import com.astroviking.pawpals.exceptions.ResourceNotFoundException;
import com.astroviking.pawpals.mappers.UserProfileMapper;
import com.astroviking.pawpals.repositorties.UserProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserProfileService {

  private final UserProfileRepository userProfileRepository;
  private final UserProfileMapper userProfileMapper;

  public UserProfileService(UserProfileRepository userProfileRepository, UserProfileMapper userProfileMapper) {
    this.userProfileRepository = userProfileRepository;
    this.userProfileMapper = userProfileMapper;
  }

  public Optional<UserProfileDTO> findById(String id) {
    Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
    return userProfileOptional.map(userProfileMapper::mapToDTO);
  }

  public UserProfileDTO save(String id, UserProfileDTO userProfileDTO) {
    Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);
    if (userProfileOptional.isPresent()) {
      throw new ConflictingResourceException("A user profile for this ID already exists.");
    }
    UserProfile userProfile = userProfileMapper.mapToEntity(userProfileDTO);
    userProfile.setId(id);
    userProfile = userProfileRepository.save(userProfile);
    return userProfileMapper.mapToDTO(userProfile);
  }

  public UserProfileDTO update(String id, UserProfileDTO dto) {
    Optional<UserProfile> userProfileOptional = userProfileRepository.findById(id);

    UserProfile userProfile = userProfileOptional.orElseThrow(ResourceNotFoundException::new);

    userProfile.setLastName(dto.getLastName());
    userProfile.setFirstName(dto.getFirstName());
    userProfile.setEmail(dto.getEmail());

    userProfile = userProfileRepository.save(userProfile);

    return userProfileMapper.mapToDTO(userProfile);
  }

}
