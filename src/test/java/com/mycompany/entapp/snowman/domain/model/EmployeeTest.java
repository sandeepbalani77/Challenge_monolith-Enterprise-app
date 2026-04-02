package com.mycompany.entapp.snowman.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testGettersAndSetters() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstname("John");
        employee.setSurname("Doe");
        assertEquals(1, employee.getId());
        assertEquals("John", employee.getFirstname());
        assertEquals("Doe", employee.getSurname());
    }

    @Test
    void testEquals() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setFirstname("John");
        e1.setSurname("Doe");
        Employee e2 = new Employee();
        e2.setId(1);
        e2.setFirstname("John");
        e2.setSurname("Doe");
        assertEquals(e1, e2);
    }

    @Test
    void testNotEquals() {
        Employee e1 = new Employee();
        e1.setId(1);
        Employee e2 = new Employee();
        e2.setId(2);
        assertNotEquals(e1, e2);
    }

    @Test
    void testHashCode() {
        Employee e1 = new Employee();
        e1.setId(1);
        e1.setFirstname("John");
        Employee e2 = new Employee();
        e2.setId(1);
        e2.setFirstname("John");
        assertEquals(e1.hashCode(), e2.hashCode());
    }

    @Test
    void testToString() {
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstname("John");
        assertNotNull(employee.toString());
    }
}
