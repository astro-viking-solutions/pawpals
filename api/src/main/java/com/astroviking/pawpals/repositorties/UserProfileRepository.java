package com.astroviking.pawpals.repositorties;

import com.astroviking.pawpals.domain.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, String> {

}
