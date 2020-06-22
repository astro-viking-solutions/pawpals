package com.astroviking.pawpals.controllers;

import com.astroviking.pawpals.domain.Pet;
import com.astroviking.pawpals.services.PetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PetControllerTest {

  @MockBean PetService petService;

  @Autowired MockMvc mockMvc;

  @Test
  public void findPets() throws Exception {
    Pet pet1 = new Pet(1L, "Pet1");
    Pet pet2 = new Pet(2L, "Pet2");
    List<Pet> pets = Arrays.asList(pet1, pet2);

    when(petService.getPets()).thenReturn(pets);

    mockMvc.perform(get("/pets")).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

    verify(petService, times(1)).getPets();
  }
}
