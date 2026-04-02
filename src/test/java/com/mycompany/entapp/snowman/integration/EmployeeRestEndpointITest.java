package com.mycompany.entapp.snowman.integration;

import com.mycompany.entapp.snowman.EnterpriseApplication;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.EmployeeResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EnterpriseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeRestEndpointITest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetEmployeeById() {
        ResponseEntity<EmployeeResource> response = restTemplate.getForEntity("/employees/1", EmployeeResource.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Colin", response.getBody().getFirstName());
    }

    @Test
    void testGetEmployeeNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/employees/999", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
