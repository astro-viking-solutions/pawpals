package com.astroviking.pawpals.controllers;

import com.astroviking.pawpals.domain.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping
  public User getCurrentUser(@AuthenticationPrincipal Jwt jwt) {
    User user = new User();
    user.setFirstName("First");
    user.setLastName("Last");
    return user;
  }

}
