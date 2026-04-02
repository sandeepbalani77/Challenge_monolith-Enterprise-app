package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.EmployeeJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeRepositoryImplUTest {

    @Mock
    private EmployeeJpaRepository employeeJpaRepository;

    @InjectMocks
    private EmployeeRepositoryImpl employeeRepository;

    @Test
    void testFindEmployee() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        when(employeeJpaRepository.findById(1)).thenReturn(Optional.of(employee));
        Employee result = employeeRepository.findEmployee(1);
        assertEquals(employee, result);
    }

    @Test
    void testFindEmployeeNotFound() {
        when(employeeJpaRepository.findById(99)).thenReturn(Optional.empty());
        assertNull(employeeRepository.findEmployee(99));
    }

    @Test
    void testSaveEmployee() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        employeeRepository.saveEmployee(employee);
        verify(employeeJpaRepository).save(employee);
    }

    @Test
    void testRemoveEmployee() {
        employeeRepository.removeEmployee(1);
        verify(employeeJpaRepository).deleteById(1);
    }
}
