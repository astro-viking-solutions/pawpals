package com.astroviking.petpals.services;

import com.astroviking.petpals.domain.Pet;
import com.astroviking.petpals.repositorties.PetRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class PetServiceTest {

  @MockBean
  PetRepository petRepository;

  @Autowired
  PetService petService;

  @Test
  public void getPets() {

    List<Pet> petList = Arrays.asList(new Pet(), new Pet());

    when(petRepository.findAll()).thenReturn(petList);

    List<Pet> pets = petService.getPets();

    assertEquals(2, pets.size());
  }



}
