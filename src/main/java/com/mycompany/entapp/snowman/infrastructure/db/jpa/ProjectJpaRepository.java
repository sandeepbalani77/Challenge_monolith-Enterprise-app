package com.mycompany.entapp.snowman.infrastructure.db.jpa;

import com.mycompany.entapp.snowman.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectJpaRepository extends JpaRepository<Project, Integer> {
}
