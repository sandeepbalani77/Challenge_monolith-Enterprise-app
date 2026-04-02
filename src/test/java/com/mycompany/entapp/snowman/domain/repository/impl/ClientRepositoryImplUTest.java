package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.ClientJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientRepositoryImplUTest {

    @Mock
    private ClientJpaRepository clientJpaRepository;

    @InjectMocks
    private ClientRepositoryImpl clientRepository;

    @Test
    void testGetClient() {
        Client client = new Client();
        client.setId(1);
        client.setClientName("Test");
        when(clientJpaRepository.findById(1)).thenReturn(Optional.of(client));
        Client result = clientRepository.getClient(1);
        assertEquals("Test", result.getClientName());
    }

    @Test
    void testGetClientNotFound() {
        when(clientJpaRepository.findById(99)).thenReturn(Optional.empty());
        assertNull(clientRepository.getClient(99));
    }

    @Test
    void testCreateClient() {
        Client client = new Client();
        client.setId(1);
        when(clientJpaRepository.save(client)).thenReturn(client);
        Client result = clientRepository.createClient(client);
        assertEquals(client, result);
    }

    @Test
    void testUpdateClient() {
        Client client = new Client();
        client.setId(1);
        when(clientJpaRepository.save(client)).thenReturn(client);
        Client result = clientRepository.updateClient(client);
        assertEquals(client, result);
    }

    @Test
    void testDeleteClient() {
        clientRepository.deleteClient(1);
        verify(clientJpaRepository).deleteById(1);
    }
}
