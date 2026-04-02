package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.repository.ClientRepository;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.ClientJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private ClientJpaRepository clientJpaRepository;

    @Cacheable(value = "clientFindCache", key = "#clientId")
    @Override
    public Client getClient(int clientId) {
        return clientJpaRepository.findById(clientId).orElse(null);
    }

    @Override
    public Client createClient(Client client) {
        return clientJpaRepository.save(client);
    }

    @CachePut(value = "clientFindCache", key = "#client.id")
    @Override
    public Client updateClient(Client client) {
        return clientJpaRepository.save(client);
    }

    @CacheEvict(value = "clientFindCache", key = "#clientId")
    @Override
    public void deleteClient(int clientId) {
        clientJpaRepository.deleteById(clientId);
    }
}
