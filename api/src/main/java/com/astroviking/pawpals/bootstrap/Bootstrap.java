package com.astroviking.pawpals.bootstrap;

import com.astroviking.pawpals.domain.BreedRegistry;
import com.astroviking.pawpals.domain.GeoState;
import com.astroviking.pawpals.domain.Pet;
import com.astroviking.pawpals.domain.Breed;
import com.astroviking.pawpals.repositorties.BreedRegistryRepository;
import com.astroviking.pawpals.repositorties.GeoStateRepository;
import com.astroviking.pawpals.repositorties.PetBreedRepository;
import com.astroviking.pawpals.repositorties.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
@Slf4j
public class Bootstrap implements CommandLineRunner {

  private final PetRepository petRepository;
  private final PetBreedRepository petBreedRepository;
  private final GeoStateRepository geoStateRepository;
  private final BreedRegistryRepository breedRegistryRepository;

  public Bootstrap(
      PetRepository petRepository,
      PetBreedRepository petBreedRepository,
      GeoStateRepository geoStateRepository,
      BreedRegistryRepository breedRegistryRepository) {
    this.petRepository = petRepository;
    this.petBreedRepository = petBreedRepository;
    this.geoStateRepository = geoStateRepository;
    this.breedRegistryRepository = breedRegistryRepository;
  }

  @Override
  public void run(String... args) throws IOException {
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

  private void loadPetBreeds() throws IOException {

    BreedRegistry akc = new BreedRegistry();
    akc.setAbbreviation("AKC");
    akc.setName("American Kennel Club");
    akc.setWebsite("https://www.akc.org/");

    akc = breedRegistryRepository.save(akc);

    File akcBreedsFile =
        new File(
            Objects.requireNonNull(
                    getClass().getClassLoader().getResource("domain/akc-dog-breeds.csv"))
                .getFile());

    List<String> akcBreeds = Files.readAllLines(Paths.get(akcBreedsFile.getPath()));

    List<Breed> breedList = new ArrayList<>();

    for (String akcBreed : akcBreeds) {
      Breed breed = new Breed();
      breed.setName(akcBreed);
      breed.setBreedRegistries(Collections.singletonList(akc));
      breedList.add(breed);
    }

    petBreedRepository.saveAll(breedList);

    log.info("Loaded {} pet breeds.", petBreedRepository.count());
  }

  private void loadGeoStates() throws IOException {
    File statesFile =
        new File(
            Objects.requireNonNull(getClass().getClassLoader().getResource("domain/us-states.csv"))
                .getFile());

    List<String> statesLines = Files.readAllLines(Paths.get(statesFile.getPath()));

    List<GeoState> states = new ArrayList<>();

    for (String line : statesLines) {
      String[] lineArray = line.split(",");
      states.add(new GeoState(lineArray[1], lineArray[0]));
    }

    geoStateRepository.saveAll(states);

    log.info("Loaded {} states.", geoStateRepository.count());
  }
}
