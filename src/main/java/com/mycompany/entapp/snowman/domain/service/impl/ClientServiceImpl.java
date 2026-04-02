package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.repository.ClientRepository;
import com.mycompany.entapp.snowman.domain.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

@Service
public class ClientServiceImpl implements ClientService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

    private static final String CLIENT_SYSTEM_BASE_URL = "http://localhost:9999/clients/";

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Client getClient(int clientId) {
        Client client = clientRepository.getClient(clientId);

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(CLIENT_SYSTEM_BASE_URL + clientId, String.class);
            if (response.getStatusCode() == HttpStatus.OK) {
                processResponse(response.getBody(), client);
            }
        } catch (Exception ex) {
            LOGGER.warn("Could not reach client system, retrying...", ex);
            try {
                ResponseEntity<String> response = restTemplate.getForEntity(CLIENT_SYSTEM_BASE_URL + clientId, String.class);
                if (response.getStatusCode() == HttpStatus.OK) {
                    processResponse(response.getBody(), client);
                }
            } catch (Exception e) {
                LOGGER.error("Retry to Client System also failed", e);
            }
        }

        return client;
    }

    void processResponse(String responseBody, Client client) {
        Set<Project> projects = new HashSet<>();
        try {
            // Parse response body into projects
            // In a real implementation, this would parse JSON into Project objects
            if (responseBody != null && !responseBody.isEmpty()) {
                LOGGER.debug("Processing response body: {}", responseBody);
            }
        } catch (Exception ex) {
            LOGGER.error("Error processing response", ex);
        }
        client.setProjects(projects);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.createClient(client);
    }

    @Override
    public void updateClient(Client client) {
        clientRepository.updateClient(client);
    }

    @Override
    public void deleteClient(int clientId) {
        clientRepository.deleteClient(clientId);
    }
}
