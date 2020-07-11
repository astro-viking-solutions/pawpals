package com.astroviking.pawpals.controllers;

import com.astroviking.pawpals.dto.UserProfileDTO;
import com.astroviking.pawpals.exceptions.ResourceNotFoundException;
import com.astroviking.pawpals.services.UserProfileService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@RequestMapping("/user/profile")
public class UserProfileController {

  private final UserProfileService userProfileService;

  public UserProfileController(UserProfileService userProfileService) {
    this.userProfileService = userProfileService;
  }

  @GetMapping
  public UserProfileDTO getUserProfile(@AuthenticationPrincipal Principal principal) {
    Optional<UserProfileDTO> optionalUserProfileDTO = userProfileService.findById(principal.getName());

    return optionalUserProfileDTO.orElseThrow(ResourceNotFoundException::new);
  }

  @PostMapping
  public UserProfileDTO createUserProfile(@AuthenticationPrincipal Principal principal, @RequestBody UserProfileDTO dto) {
    return  userProfileService.save(principal.getName(), dto);
  }

  @PutMapping
  public UserProfileDTO updateUserProfile(@AuthenticationPrincipal Principal principal, @RequestBody UserProfileDTO dto) {
    return userProfileService.update(principal.getName(), dto);
  }
}
