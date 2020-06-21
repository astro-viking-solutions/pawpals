package com.astroviking.petpals.controllers;

import com.astroviking.petpals.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @GetMapping("/info")
  public User getCurrentUser() {
    User user = new User();
    user.setFirstName("First");
    user.setLastName("Last");
    return user;
  }

}
