package com.mycompany.entapp.snowman.infrastructure.db.jpa;

import com.mycompany.entapp.snowman.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {
}
