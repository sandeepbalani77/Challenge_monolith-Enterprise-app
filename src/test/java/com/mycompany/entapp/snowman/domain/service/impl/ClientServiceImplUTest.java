package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientServiceImplUTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ClientServiceImpl clientService;

    @Test
    void testGetClient() {
        Client client = new Client();
        client.setId(1);
        client.setClientName("Test Client");
        when(clientRepository.getClient(1)).thenReturn(client);
        Client result = clientService.getClient(1);
        assertNotNull(result);
        assertEquals("Test Client", result.getClientName());
    }

    @Test
    void testCreateClient() {
        Client client = new Client();
        client.setId(1);
        clientService.createClient(client);
        verify(clientRepository).createClient(client);
    }

    @Test
    void testUpdateClient() {
        Client client = new Client();
        client.setId(1);
        clientService.updateClient(client);
        verify(clientRepository).updateClient(client);
    }

    @Test
    void testDeleteClient() {
        clientService.deleteClient(1);
        verify(clientRepository).deleteClient(1);
    }
}
