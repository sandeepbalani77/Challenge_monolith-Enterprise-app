package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.repository.EmployeeRepository;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private EmployeeJpaRepository employeeJpaRepository;

    @Override
    public Employee findEmployee(int employeeId) {
        return employeeJpaRepository.findById(employeeId).orElse(null);
    }

    @Override
    public void saveEmployee(Employee employee) {
        employeeJpaRepository.save(employee);
    }

    @Override
    public void removeEmployee(int employeeId) {
        employeeJpaRepository.deleteById(employeeId);
    }
}
