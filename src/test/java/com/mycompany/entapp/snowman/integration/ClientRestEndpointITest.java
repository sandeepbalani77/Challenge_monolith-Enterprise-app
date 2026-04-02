package com.mycompany.entapp.snowman.integration;

import com.mycompany.entapp.snowman.EnterpriseApplication;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ClientResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = EnterpriseApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientRestEndpointITest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testCreateClient() {
        ClientResource clientResource = new ClientResource();
        clientResource.setClientId(100);
        clientResource.setClientName("Integration Test Client");
        ResponseEntity<Void> response = restTemplate.postForEntity("/clients/create", clientResource, Void.class);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testDeleteClient() {
        ResponseEntity<Void> deleteResponse = restTemplate.exchange("/clients/6",
            org.springframework.http.HttpMethod.DELETE, null, Void.class);
        assertEquals(HttpStatus.OK, deleteResponse.getStatusCode());
    }

    @Test
    void testGetClientNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/clients/999", String.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
