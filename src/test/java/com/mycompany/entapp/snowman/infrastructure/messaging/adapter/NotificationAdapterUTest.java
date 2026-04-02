package com.mycompany.entapp.snowman.infrastructure.messaging.adapter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class NotificationAdapterUTest {

    @Mock
    private JmsTemplate notificationJmsTemplate;

    @InjectMocks
    private NotificationAdapter notificationAdapter;

    @Test
    void testSendUpdateNotification() {
        String testObject = "test notification";
        notificationAdapter.sendUpdateNotification(testObject);
        verify(notificationJmsTemplate).convertAndSend(testObject);
    }
}
