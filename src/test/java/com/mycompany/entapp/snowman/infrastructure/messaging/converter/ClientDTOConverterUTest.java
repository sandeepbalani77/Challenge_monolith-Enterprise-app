package com.mycompany.entapp.snowman.infrastructure.messaging.converter;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ClientDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientDTOConverterUTest {

    @Test
    void testConvertToClientDTO() {
        Client client = new Client();
        client.setId(1);
        client.setClientName("Test Client");
        ClientDTO dto = ClientDTOConverter.convertToClientDTO(client);
        assertEquals(1, dto.getClientId());
        assertEquals("Test Client", dto.getClientName());
    }
}
