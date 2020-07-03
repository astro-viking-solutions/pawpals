package com.astroviking.pawpals.repositorties;

import com.astroviking.pawpals.domain.BreedRegistry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BreedRegistryRepository extends JpaRepository<BreedRegistry, Long> {
}
