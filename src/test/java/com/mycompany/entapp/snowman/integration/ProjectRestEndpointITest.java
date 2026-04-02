package com.mycompany.entapp.snowman.integration;

import com.mycompany.entapp.snowman.EnterpriseApplication;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EnterpriseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectRestEndpointITest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetProject() {
        ResponseEntity<ProjectResource> response = restTemplate.getForEntity("/project/1", ProjectResource.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetProjectNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/project/999", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
