package com.mycompany.entapp.snowman.infrastructure.messaging.adapter;

import com.mycompany.entapp.snowman.infrastructure.messaging.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PayrollSystemAdapterUTest {

    @Mock
    private JmsTemplate payrollJmsTemplate;

    @InjectMocks
    private PayrollSystemAdapter payrollSystemAdapter;

    @Test
    void testSendEmployeeData() {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(1);
        dto.setFirstName("John");
        payrollSystemAdapter.sendEmployeeData(dto);
        verify(payrollJmsTemplate).convertAndSend(eq(dto), any(MessagePostProcessor.class));
    }
}
