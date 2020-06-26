package com.astroviking.pawpals.repositorties;

import com.astroviking.pawpals.controllers.UserProfileController;
import com.astroviking.pawpals.dto.UserProfileDTO;
import com.astroviking.pawpals.mappers.UserProfileMapper;
import com.astroviking.pawpals.services.UserProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserProfileController.class)
class UserProfileControllerTest {

  @MockBean UserProfileService userProfileService;
  @MockBean UserProfileMapper userProfileMapper;

  @Autowired MockMvc mockMvc;

  @Test
  @WithMockUser(value = "test")
  void getUserProfile() throws Exception {
    String id = "test";

    UserProfileDTO userProfile = new UserProfileDTO();
    userProfile.setEmail("email");
    userProfile.setFirstName("first");
    userProfile.setLastName("last");

    when(userProfileService.findById(id)).thenReturn(Optional.of(userProfile));

    mockMvc.perform(get("/user/profile")).andExpect(status().isOk());
  }

  @Test
  @WithMockUser(value = "test")
  void getUserProfileNotFound() throws Exception {
    String id = "test";

    when(userProfileService.findById(id)).thenReturn(Optional.empty());

    mockMvc.perform(get("/user/profile")).andExpect(status().isNotFound());
  }

  @Test
  @WithMockUser(value = "test")
  void createUserProfile() throws Exception {
    mockMvc
        .perform(post("/user/profile").content(dtoJson()))
        .andExpect(status().isOk());

    verify(userProfileService, times(1)).save(any(), any());
  }

  @Test
  @WithMockUser(value = "test")
  void updateUserProfile() throws Exception {
    mockMvc.perform(put("/user/profile").content(dtoJson())).andExpect(status().isOk());
  }

  private String dtoJson() throws JsonProcessingException {
    UserProfileDTO dto = new UserProfileDTO();
    dto.setEmail("email");
    dto.setFirstName("first");
    dto.setLastName("last");

    ObjectMapper mapper = new ObjectMapper();

    return mapper.writeValueAsString(dto);
  }
}
