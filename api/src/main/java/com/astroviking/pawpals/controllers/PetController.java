package com.astroviking.pawpals.controllers;

import com.astroviking.pawpals.domain.Pet;
import com.astroviking.pawpals.services.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

  private final PetService petService;

  public PetController(PetService petService) {
    this.petService = petService;
  }

  @GetMapping
  public List<Pet> listPets() {
    return petService.getPets();
  }

}
