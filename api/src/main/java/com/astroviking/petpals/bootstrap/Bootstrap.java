package com.astroviking.petpals.bootstrap;

import com.astroviking.petpals.domain.Pet;
import com.astroviking.petpals.repositorties.PetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Bootstrap implements CommandLineRunner {


  private final PetRepository petRepository;

  public Bootstrap(PetRepository petRepository) {
    this.petRepository = petRepository;
  }

  @Override
  public void run(String... args) {
      Pet pet1 = new Pet(1L, "Doggo");
      petRepository.save(pet1);

      Pet pet2 = new Pet(2L, "Catty");
      petRepository.save(pet2);

      log.info("Loaded {} pet records.", petRepository.count());
  }
}
