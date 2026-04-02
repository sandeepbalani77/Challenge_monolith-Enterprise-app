package com.mycompany.entapp.snowman.infrastructure.db.jpa;

import com.mycompany.entapp.snowman.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {
}
