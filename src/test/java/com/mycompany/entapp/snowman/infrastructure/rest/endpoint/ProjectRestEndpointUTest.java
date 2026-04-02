package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.ProjectTestHelper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.service.ProjectService;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectRestEndpointUTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectRestEndpoint endpoint;

    @Test
    void testGetProject() {
        Project project = ProjectTestHelper.createTestProject();
        when(projectService.getProject(1)).thenReturn(project);
        ResponseEntity<ProjectResource> response = endpoint.getProject(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testGetProjectNotFound() {
        when(projectService.getProject(99)).thenReturn(null);
        ResponseEntity<ProjectResource> response = endpoint.getProject(99);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteProject() {
        ResponseEntity<Void> response = endpoint.deleteProject(1);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(projectService).deleteProject(1);
    }
}
