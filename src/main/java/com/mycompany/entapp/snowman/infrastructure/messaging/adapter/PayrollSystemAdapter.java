package com.mycompany.entapp.snowman.infrastructure.messaging.adapter;

import com.mycompany.entapp.snowman.infrastructure.messaging.PayrollSystemPort;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.EmployeeDTO;
import jakarta.jms.DeliveryMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PayrollSystemAdapter implements PayrollSystemPort {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayrollSystemAdapter.class);

    private static final long MESSAGE_EXPIRATION_IN_MS = 86400000L;

    @Autowired
    @Qualifier("payrollJmsTemplate")
    private JmsTemplate payrollJmsTemplate;

    @Override
    public void sendEmployeeData(EmployeeDTO employeeDTO) {
        LOGGER.info("Sending employee data to Payroll System: {}", employeeDTO);
        payrollJmsTemplate.convertAndSend(employeeDTO, message -> {
            message.setJMSCorrelationID("payroll-correlation-id");
            message.setJMSDeliveryMode(DeliveryMode.PERSISTENT);
            message.setJMSExpiration(MESSAGE_EXPIRATION_IN_MS);
            message.setJMSPriority(5);
            return message;
        });
    }
}
