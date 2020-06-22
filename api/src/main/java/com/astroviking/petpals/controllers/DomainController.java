package com.astroviking.petpals.controllers;

import com.astroviking.petpals.domain.GeoState;
import com.astroviking.petpals.domain.PetBreed;
import com.astroviking.petpals.repositorties.GeoStateRepository;
import com.astroviking.petpals.repositorties.PetBreedRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/domain")
public class DomainController {

  private final PetBreedRepository petBreedRepository;
  private final GeoStateRepository geoStateRepository;

  public DomainController(PetBreedRepository petBreedRepository, GeoStateRepository geoStateRepository) {
    this.petBreedRepository = petBreedRepository;
    this.geoStateRepository = geoStateRepository;
  }

  @GetMapping("/breeds")
  public List<PetBreed> getPetBreeds() {
    return petBreedRepository.findAll();
  }

  @GetMapping("/states")
  public List<GeoState> getGeoStates() {
    return geoStateRepository.findAll();
  }
}
