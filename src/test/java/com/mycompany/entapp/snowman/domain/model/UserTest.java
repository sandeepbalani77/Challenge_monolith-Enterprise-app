package com.mycompany.entapp.snowman.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testGettersAndSetters() {
        User user = new User();
        user.setUserId(1);
        user.setUsername("admin");
        user.setPassword("pass");
        user.setEmail("admin@test.com");
        user.setFirstname("First");
        user.setLastname("Last");
        assertEquals(1, user.getUserId());
        assertEquals("admin", user.getUsername());
        assertEquals("pass", user.getPassword());
        assertEquals("admin@test.com", user.getEmail());
        assertEquals("First", user.getFirstname());
        assertEquals("Last", user.getLastname());
    }
}
