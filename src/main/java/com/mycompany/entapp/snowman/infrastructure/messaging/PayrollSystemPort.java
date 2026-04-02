package com.mycompany.entapp.snowman.infrastructure.messaging;

import com.mycompany.entapp.snowman.infrastructure.messaging.dto.EmployeeDTO;

public interface PayrollSystemPort {
    void sendEmployeeData(EmployeeDTO employeeDTO);
}
