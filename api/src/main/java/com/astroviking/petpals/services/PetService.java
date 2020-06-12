package com.astroviking.petpals.services;

import com.astroviking.petpals.domain.Pet;
import com.astroviking.petpals.repositorties.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

  private final PetRepository petRepository;

  public PetService(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  public List<Pet> getPets() {
    return petRepository.findAll();
  }
}
