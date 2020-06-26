package com.astroviking.pawpals.controllers;

import com.astroviking.pawpals.domain.GeoState;
import com.astroviking.pawpals.domain.Breed;
import com.astroviking.pawpals.repositorties.GeoStateRepository;
import com.astroviking.pawpals.repositorties.PetBreedRepository;
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
  public List<Breed> getPetBreeds() {
    return petBreedRepository.findAll();
  }

  @GetMapping("/states")
  public List<GeoState> getGeoStates() {
    return geoStateRepository.findAll();
  }
}
