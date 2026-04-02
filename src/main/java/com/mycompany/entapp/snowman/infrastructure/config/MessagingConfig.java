package com.mycompany.entapp.snowman.infrastructure.config;

import jakarta.jms.ConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQQueue;
import org.apache.activemq.artemis.jms.client.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MessagingConfig {

    @Bean
    public ActiveMQQueue invoiceSystemQueue() {
        return new ActiveMQQueue("invoice-system-queue");
    }

    @Bean
    public ActiveMQQueue payrollSystemQueue() {
        return new ActiveMQQueue("payroll-system-queue");
    }

    @Bean
    public ActiveMQTopic notificationTopic() {
        return new ActiveMQTopic("notification-topic");
    }

    @Bean
    public JmsTemplate invoiceJmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate t = new JmsTemplate(connectionFactory);
        t.setDefaultDestination(invoiceSystemQueue());
        return t;
    }

    @Bean
    public JmsTemplate payrollJmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate t = new JmsTemplate(connectionFactory);
        t.setDefaultDestination(payrollSystemQueue());
        return t;
    }

    @Bean
    public JmsTemplate notificationJmsTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate t = new JmsTemplate(connectionFactory);
        t.setDefaultDestination(notificationTopic());
        return t;
    }
}
