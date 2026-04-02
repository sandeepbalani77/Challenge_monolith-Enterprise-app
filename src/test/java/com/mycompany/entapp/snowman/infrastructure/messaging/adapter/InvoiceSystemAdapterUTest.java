package com.mycompany.entapp.snowman.infrastructure.messaging.adapter;

import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ClientDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class InvoiceSystemAdapterUTest {

    @Mock
    private JmsTemplate invoiceJmsTemplate;

    @InjectMocks
    private InvoiceSystemAdapter invoiceSystemAdapter;

    @Test
    void testSendClientData() {
        ClientDTO dto = new ClientDTO();
        dto.setClientId(1);
        invoiceSystemAdapter.sendClientData(dto);
        verify(invoiceJmsTemplate).send(any(MessageCreator.class));
    }
}
