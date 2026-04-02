package com.mycompany.entapp.snowman.infrastructure.messaging.converter;

import com.mycompany.entapp.snowman.domain.EmployeeTestHelper;
import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDTOConverterUTest {

    @Test
    void testConvertToEmployeeDTO() {
        Employee employee = EmployeeTestHelper.createTestEmployee();
        EmployeeDTO dto = EmployeeDTOConverter.convertToEmployeeDTO(employee);
        assertEquals(employee.getId(), dto.getId());
        assertEquals(employee.getFirstname(), dto.getFirstName());
        assertEquals(employee.getSurname(), dto.getSurname());
        assertEquals(employee.getRole().getRole(), dto.getRole());
    }
}
