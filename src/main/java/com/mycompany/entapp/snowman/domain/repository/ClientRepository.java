package com.mycompany.entapp.snowman.domain.repository;

import com.mycompany.entapp.snowman.domain.model.Client;

public interface ClientRepository {
    Client getClient(int clientId);
    Client createClient(Client client);
    Client updateClient(Client client);
    void deleteClient(int clientId);
}
