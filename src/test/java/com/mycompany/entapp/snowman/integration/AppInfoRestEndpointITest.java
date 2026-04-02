package com.mycompany.entapp.snowman.integration;

import com.mycompany.entapp.snowman.EnterpriseApplication;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.AppInfoResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EnterpriseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppInfoRestEndpointITest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testGetAppInfo() {
        ResponseEntity<AppInfoResource> response = restTemplate.getForEntity("/appinfo", AppInfoResource.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testActuatorHealth() {
        ResponseEntity<String> response = restTemplate.getForEntity("/actuator/health", String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody().contains("UP"));
    }
}
