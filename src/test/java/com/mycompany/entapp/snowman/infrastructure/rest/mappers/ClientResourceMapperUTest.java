package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ClientResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientResourceMapperUTest {

    @Test
    void testMapToClientResource() {
        Client client = new Client();
        client.setId(1);
        client.setClientName("Test Client");
        ClientResource resource = ClientResourceMapper.mapToClientResource(client);
        assertEquals(1, resource.getClientId());
        assertEquals("Test Client", resource.getClientName());
    }

    @Test
    void testMapToClient() {
        ClientResource resource = new ClientResource();
        resource.setClientId(1);
        resource.setClientName("Test Client");
        Client client = ClientResourceMapper.mapToClient(resource);
        assertEquals(1, client.getId());
        assertEquals("Test Client", client.getClientName());
    }
}
