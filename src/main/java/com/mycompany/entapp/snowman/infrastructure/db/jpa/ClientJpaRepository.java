package com.mycompany.entapp.snowman.infrastructure.db.jpa;

import com.mycompany.entapp.snowman.domain.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientJpaRepository extends JpaRepository<Client, Integer> {
}
