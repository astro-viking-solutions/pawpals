package com.astroviking.pawpals.repositorties;

import com.astroviking.pawpals.domain.PetBreed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetBreedRepository extends JpaRepository<PetBreed, Long> {
}
