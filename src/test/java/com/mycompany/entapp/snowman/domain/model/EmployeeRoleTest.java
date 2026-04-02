package com.mycompany.entapp.snowman.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRoleTest {

    @Test
    void testGettersAndSetters() {
        EmployeeRole role = new EmployeeRole();
        role.setId(1);
        role.setRole("Developer");
        assertEquals(1, role.getId());
        assertEquals("Developer", role.getRole());
    }

    @Test
    void testEquals() {
        EmployeeRole r1 = new EmployeeRole();
        r1.setId(1);
        r1.setRole("Developer");
        EmployeeRole r2 = new EmployeeRole();
        r2.setId(1);
        r2.setRole("Developer");
        assertEquals(r1, r2);
    }

    @Test
    void testHashCode() {
        EmployeeRole r1 = new EmployeeRole();
        r1.setId(1);
        EmployeeRole r2 = new EmployeeRole();
        r2.setId(1);
        assertEquals(r1.hashCode(), r2.hashCode());
    }

    @Test
    void testToString() {
        EmployeeRole role = new EmployeeRole();
        role.setId(1);
        assertNotNull(role.toString());
    }
}
