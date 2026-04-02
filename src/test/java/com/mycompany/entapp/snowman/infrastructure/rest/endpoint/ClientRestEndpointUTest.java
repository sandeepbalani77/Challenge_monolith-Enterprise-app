package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ClientResource;
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
class ClientRestEndpointUTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientRestEndpoint endpoint;

    @Test
    void testGetClient() {
        Client client = new Client();
        client.setId(1);
        client.setClientName("Test Client");
        when(clientService.getClient(1)).thenReturn(client);
        ResponseEntity<ClientResource> response = endpoint.getClient(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetClientNotFound() {
        when(clientService.getClient(99)).thenReturn(null);
        ResponseEntity<ClientResource> response = endpoint.getClient(99);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateClient() throws Exception {
        ClientResource resource = new ClientResource();
        resource.setClientName("Test");
        ResponseEntity<Void> response = endpoint.createClient(resource);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void testDeleteClient() throws Exception {
        ResponseEntity<Void> response = endpoint.deleteClient(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(clientService).deleteClient(1);
    }
}
