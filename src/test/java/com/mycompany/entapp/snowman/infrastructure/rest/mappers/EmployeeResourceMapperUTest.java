package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.EmployeeResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeResourceMapperUTest {

    @Test
    void testMapEmployeeToResource() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        EmployeeResource resource = EmployeeResourceMapper.mapEmployeeToEmployeeResource(employee);
        assertEquals(employee.getId(), resource.getEmployeeId());
        assertEquals(employee.getFirstname(), resource.getFirstName());
        assertEquals(employee.getSurname(), resource.getSecondName());
        assertEquals(employee.getRole().getRole(), resource.getRole());
    }

    @Test
    void testMapResourceToEmployee() {
        EmployeeResource resource = new EmployeeResource();
        resource.setEmployeeId(1);
        resource.setFirstName("John");
        resource.setSecondName("Doe");
        resource.setRole("Developer");
        Employee employee = EmployeeResourceMapper.mapEmployeeResourceToEmployee(resource);
        assertEquals(1, employee.getId());
        assertEquals("John", employee.getFirstname());
        assertEquals("Doe", employee.getSurname());
        assertEquals("Developer", employee.getRole().getRole());
    }
}
