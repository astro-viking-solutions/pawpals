package com.astroviking.pawpals.services;

import com.astroviking.pawpals.domain.UserProfile;
import com.astroviking.pawpals.dto.UserProfileDTO;
import com.astroviking.pawpals.exceptions.ConflictingResourceException;
import com.astroviking.pawpals.exceptions.ResourceNotFoundException;
import com.astroviking.pawpals.mappers.UserProfileMapper;
import com.astroviking.pawpals.repositorties.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class UserProfileServiceTest {

  @Mock UserProfileRepository userProfileRepository;
  @Mock UserProfileMapper userProfileMapper;

  @InjectMocks UserProfileService userProfileService;

  @Test
  void findById() {
    String id = "test";
    UserProfile userProfile = new UserProfile();
    userProfile.setId("id");
    userProfile.setEmail("email");
    userProfile.setFirstName("first");
    userProfile.setLastName("last");

    when(userProfileRepository.findById(id)).thenReturn(Optional.of(userProfile));
    when(userProfileMapper.mapToDTO(any())).thenReturn(new UserProfileDTO());
    Optional<UserProfileDTO> dto = userProfileService.findById(id);
    assertTrue(dto.isPresent());
  }

  @Test
  void save() {
    String id = "id";

    UserProfileDTO dto = new UserProfileDTO();
    dto.setEmail("email");
    dto.setFirstName("first");
    dto.setLastName("last");

    UserProfile entity = new UserProfile();
    entity.setEmail("email");
    entity.setFirstName("first");
    entity.setLastName("last");

    when(userProfileRepository.findById(id)).thenReturn(Optional.empty());
    when(userProfileMapper.mapToEntity(any())).thenReturn(entity);
    when(userProfileMapper.mapToDTO(any())).thenReturn(dto);

    dto = userProfileService.save(id, dto);

    ArgumentCaptor<UserProfile> captor = ArgumentCaptor.forClass(UserProfile.class);
    verify(userProfileRepository, times(1)).save(captor.capture());
    assertEquals(id, captor.getValue().getId());
    assertNotNull(dto);
  }

  @Test
  void saveConflict() {
    String id = "id";

    UserProfileDTO dto = new UserProfileDTO();
    dto.setEmail("email");
    dto.setFirstName("first");
    dto.setLastName("last");

    UserProfile entity = new UserProfile();
    entity.setEmail("email");
    entity.setFirstName("first");
    entity.setLastName("last");

    when(userProfileRepository.findById(id)).thenReturn(Optional.of(entity));

    assertThrows(ConflictingResourceException.class, () -> userProfileService.save(id, dto));
  }

  @Test
  void update() {
    String id = "id";

    UserProfileDTO dto = new UserProfileDTO();
    dto.setEmail("email");
    dto.setFirstName("first");
    dto.setLastName("last");

    UserProfile entity = new UserProfile();
    entity.setEmail("x");
    entity.setFirstName("x");
    entity.setLastName("x");

    when(userProfileRepository.findById(id)).thenReturn(Optional.of(entity));

    userProfileService.update(id, dto);

    ArgumentCaptor<UserProfile> captor = ArgumentCaptor.forClass(UserProfile.class);
    verify(userProfileRepository, times(1)).save(captor.capture());
    verify(userProfileMapper, times(1)).mapToDTO(any());

    assertEquals(dto.getEmail(), captor.getValue().getEmail());
    assertEquals(dto.getFirstName(), captor.getValue().getFirstName());
    assertEquals(dto.getFirstName(), captor.getValue().getFirstName());
  }

  @Test
  void updateNotFound() {
    String id = "id";

    UserProfileDTO dto = new UserProfileDTO();
    dto.setEmail("email");
    dto.setFirstName("first");
    dto.setLastName("last");

    UserProfile entity = new UserProfile();
    entity.setEmail("x");
    entity.setFirstName("x");
    entity.setLastName("x");

    when(userProfileRepository.findById(id)).thenReturn(Optional.empty());

    assertThrows(ResourceNotFoundException.class, () -> userProfileService.update(id, dto));
  }
}
