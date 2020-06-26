package com.astroviking.pawpals.bootstrap;

import com.astroviking.pawpals.domain.GeoState;
import com.astroviking.pawpals.domain.Pet;
import com.astroviking.pawpals.domain.Breed;
import com.astroviking.pawpals.repositorties.GeoStateRepository;
import com.astroviking.pawpals.repositorties.PetBreedRepository;
import com.astroviking.pawpals.repositorties.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class Bootstrap implements CommandLineRunner {


  private final PetRepository petRepository;
  private final PetBreedRepository petBreedRepository;
  private final GeoStateRepository geoStateRepository;

  public Bootstrap(PetRepository petRepository, PetBreedRepository petBreedRepository, GeoStateRepository geoStateRepository) {
    this.petRepository = petRepository;
    this.petBreedRepository = petBreedRepository;
    this.geoStateRepository = geoStateRepository;
  }

  @Override
  public void run(String... args) {
    loadPets();
    loadPetBreeds();
    loadGeoStates();
  }

  private void loadPets() {
    Pet pet1 = new Pet(1L, "Doggo");
    petRepository.save(pet1);

    Pet pet2 = new Pet(2L, "Catty");
    petRepository.save(pet2);

    log.info("Loaded {} pet records.", petRepository.count());
  }

  private void loadPetBreeds() {
    List<Breed> breedList = new ArrayList<>();

    breedList.add(new Breed("Boxer"));
    breedList.add(new Breed("Welsh Corgi"));
    breedList.add(new Breed("Irish Wolfhound"));

    petBreedRepository.saveAll(breedList);

    log.info("Loaded {} pet breeds.", petBreedRepository.count());
  }

  private void loadGeoStates() {
    List<GeoState> states = new ArrayList<>();
    states.add(new GeoState("AL", "Alabama"));
    states.add(new GeoState("FL", "Florida"));

    geoStateRepository.saveAll(states);

    log.info("Loaded {} states.", geoStateRepository.count());
  }
}
