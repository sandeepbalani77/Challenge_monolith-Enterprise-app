package com.mycompany.entapp.snowman.infrastructure.messaging;

import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ClientDTO;

public interface InvoiceSystemPort {
    void sendClientData(ClientDTO clientDTO);
}
