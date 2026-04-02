package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.service.EmployeeService;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.EmployeeResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeRestEndpointUTest {

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private EmployeeRestEndpoint endpoint;

    @Test
    void testGetEmployee() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        when(employeeService.getEmployee(1)).thenReturn(employee);
        ResponseEntity<EmployeeResource> response = endpoint.getEmployee(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetEmployeeNotFound() {
        when(employeeService.getEmployee(99)).thenReturn(null);
        ResponseEntity<EmployeeResource> response = endpoint.getEmployee(99);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateEmployee() {
        EmployeeResource resource = new EmployeeResource();
        resource.setFirstName("Test");
        resource.setSecondName("User");
        resource.setRole("Developer");
        ResponseEntity<Void> response = endpoint.createEmployee(resource);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testDeleteEmployee() {
        ResponseEntity<Void> response = endpoint.deleteEmployee(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(employeeService).deleteEmployee(1);
    }
}
