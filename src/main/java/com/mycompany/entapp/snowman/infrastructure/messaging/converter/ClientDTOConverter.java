package com.mycompany.entapp.snowman.infrastructure.messaging.converter;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ClientDTO;

public final class ClientDTOConverter {

    private ClientDTOConverter() {
    }

    public static ClientDTO convertToClientDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientId(client.getId());
        clientDTO.setClientName(client.getClientName());
        clientDTO.setProjectDTOS(ProjectDTOConverter.convertToProjectDTOS(client.getProjects()));
        return clientDTO;
    }
}
