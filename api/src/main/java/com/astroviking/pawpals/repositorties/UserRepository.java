package com.astroviking.pawpals.repositorties;

import com.astroviking.pawpals.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
