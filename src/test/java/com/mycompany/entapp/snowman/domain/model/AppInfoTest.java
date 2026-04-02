package com.mycompany.entapp.snowman.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppInfoTest {

    @Test
    void testGettersAndSetters() {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        appInfo.setVersion("2.0");
        assertEquals(1, appInfo.getId());
        assertEquals("2.0", appInfo.getVersion());
    }

    @Test
    void testEquals() {
        AppInfo a1 = new AppInfo();
        a1.setId(1);
        a1.setVersion("1.0");
        AppInfo a2 = new AppInfo();
        a2.setId(1);
        a2.setVersion("1.0");
        assertEquals(a1, a2);
    }

    @Test
    void testHashCode() {
        AppInfo a1 = new AppInfo();
        a1.setId(1);
        AppInfo a2 = new AppInfo();
        a2.setId(1);
        assertEquals(a1.hashCode(), a2.hashCode());
    }

    @Test
    void testToString() {
        AppInfo appInfo = new AppInfo();
        appInfo.setId(1);
        assertNotNull(appInfo.toString());
    }
}
