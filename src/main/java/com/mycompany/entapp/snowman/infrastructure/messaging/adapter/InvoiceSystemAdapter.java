package com.mycompany.entapp.snowman.infrastructure.messaging.adapter;

import com.mycompany.entapp.snowman.infrastructure.messaging.InvoiceSystemPort;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ClientDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class InvoiceSystemAdapter implements InvoiceSystemPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceSystemAdapter.class);

    @Autowired
    @Qualifier("invoiceJmsTemplate")
    private JmsTemplate invoiceJmsTemplate;

    @Override
    public void sendClientData(ClientDTO clientDTO) {
        LOGGER.info("Sending client data to Invoice System: {}", clientDTO);
        invoiceJmsTemplate.send(session -> {
            var message = session.createObjectMessage(clientDTO);
            message.setJMSCorrelationID("invoice-correlation-id");
            return message;
        });
    }
}
