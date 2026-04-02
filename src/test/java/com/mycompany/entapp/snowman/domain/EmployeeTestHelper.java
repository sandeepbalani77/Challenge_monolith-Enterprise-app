package com.mycompany.entapp.snowman.domain;

import com.mycompany.entapp.snowman.domain.model.Employee;
import com.mycompany.entapp.snowman.domain.model.EmployeeRole;

public final class EmployeeTestHelper {

    private EmployeeTestHelper() {}

    public static Employee createTestEmployee() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstname("John");
        employee.setSurname("Doe");
        EmployeeRole role = new EmployeeRole();
        role.setId(3);
        role.setRole("Software Developer");
        employee.setRole(role);
        return employee;
    }

    public static Employee createTestEmployee(int id, String firstname, String surname, String roleName) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstname(firstname);
        employee.setSurname(surname);
        EmployeeRole role = new EmployeeRole();
        role.setId(1);
        role.setRole(roleName);
        employee.setRole(role);
        return employee;
    }
}
