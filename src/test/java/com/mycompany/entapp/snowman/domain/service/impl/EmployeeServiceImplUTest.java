package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplUTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testGetEmployee() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        when(employeeRepository.findEmployee(1)).thenReturn(employee);
        Employee result = employeeService.getEmployee(1);
        assertEquals(employee, result);
    }

    @Test
    void testCreateEmployee() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        employeeService.createEmployee(employee);
        verify(employeeRepository).saveEmployee(employee);
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        when(employeeRepository.findEmployee(employee.getId())).thenReturn(employee);
        employeeService.updateEmployee(employee);
        verify(employeeRepository).saveEmployee(employee);
    }

    @Test
    void testUpdateEmployeeShouldThrowExceptionWhenNoExistingEmployeeFound() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        when(employeeRepository.findEmployee(employee.getId())).thenReturn(null);
        assertThrows(RuntimeException.class, () -> employeeService.updateEmployee(employee));
    }

    @Test
    void testDeleteEmployee() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        when(employeeRepository.findEmployee(1)).thenReturn(employee);
        employeeService.deleteEmployee(1);
        verify(employeeRepository).removeEmployee(1);
    }

    @Test
    void testDeleteEmployeeShouldThrowExceptionWhenNoExistingEmployeeFound() {
        when(employeeRepository.findEmployee(1)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> employeeService.deleteEmployee(1));
    }
}
