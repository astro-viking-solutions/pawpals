package com.astroviking.petpals.repositorties;

import com.astroviking.petpals.domain.GeoState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoStateRepository extends JpaRepository<GeoState, Long> {
}
