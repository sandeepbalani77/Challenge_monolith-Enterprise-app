package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.ProjectTestHelper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectResourceMapperUTest {

    @Test
    void testMapToProjectResource() {
        Project project = ProjectTestHelper.createTestProject();
        ProjectResource resource = ProjectResourceMapper.mapToProjectResource(project);
        assertEquals(project.getId(), resource.getProjectId());
        assertEquals(project.getProjectTitle(), resource.getTitle());
        assertNotNull(resource.getDateStarted());
    }

    @Test
    void testMapToProject() {
        ProjectResource resource = new ProjectResource();
        resource.setProjectId(1);
        resource.setTitle("Test");
        Project project = ProjectResourceMapper.mapToProject(resource);
        assertEquals(1, project.getId());
        assertEquals("Test", project.getProjectTitle());
    }
}
