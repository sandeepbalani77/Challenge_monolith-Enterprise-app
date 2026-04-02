package com.mycompany.entapp.snowman.domain.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    @Test
    void testGettersAndSetters() {
        Project project = new Project();
        project.setId(1);
        project.setProjectTitle("Test");
        project.setDateStarted(LocalDate.of(2017, 3, 15));
        project.setDateEnded(LocalDate.of(2018, 6, 15));
        assertEquals(1, project.getId());
        assertEquals("Test", project.getProjectTitle());
        assertEquals(LocalDate.of(2017, 3, 15), project.getDateStarted());
        assertEquals(LocalDate.of(2018, 6, 15), project.getDateEnded());
    }

    @Test
    void testEquals() {
        Project p1 = new Project();
        p1.setId(1);
        p1.setProjectTitle("Test");
        Project p2 = new Project();
        p2.setId(1);
        p2.setProjectTitle("Test");
        assertEquals(p1, p2);
    }

    @Test
    void testHashCode() {
        Project p1 = new Project();
        p1.setId(1);
        Project p2 = new Project();
        p2.setId(1);
        assertEquals(p1.hashCode(), p2.hashCode());
    }

    @Test
    void testToString() {
        Project project = new Project();
        project.setId(1);
        assertNotNull(project.toString());
    }
}
