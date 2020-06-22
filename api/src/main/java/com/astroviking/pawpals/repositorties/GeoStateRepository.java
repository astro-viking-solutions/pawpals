package com.astroviking.pawpals.repositorties;

import com.astroviking.pawpals.domain.GeoState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoStateRepository extends JpaRepository<GeoState, Long> {
}
