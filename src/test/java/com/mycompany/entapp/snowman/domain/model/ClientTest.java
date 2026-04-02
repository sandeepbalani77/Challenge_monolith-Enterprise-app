package com.mycompany.entapp.snowman.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testGettersAndSetters() {
        Client client = new Client();
        client.setId(1);
        client.setClientName("Test");
        assertEquals(1, client.getId());
        assertEquals("Test", client.getClientName());
    }

    @Test
    void testEquals() {
        Client c1 = new Client();
        c1.setId(1);
        c1.setClientName("Test");
        Client c2 = new Client();
        c2.setId(1);
        c2.setClientName("Test");
        assertEquals(c1, c2);
    }

    @Test
    void testHashCode() {
        Client c1 = new Client();
        c1.setId(1);
        Client c2 = new Client();
        c2.setId(1);
        assertEquals(c1.hashCode(), c2.hashCode());
    }

    @Test
    void testToString() {
        Client client = new Client();
        client.setId(1);
        assertNotNull(client.toString());
    }
}
