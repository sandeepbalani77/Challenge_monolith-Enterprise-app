package com.mycompany.entapp.snowman.domain.service.impl;

import com.mycompany.entapp.snowman.domain.ProjectTestHelper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplUTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Test
    void testGetProject() {
        Project project = ProjectTestHelper.createTestProject();
        when(projectRepository.findProject(1)).thenReturn(project);
        assertEquals(project, projectService.getProject(1));
    }

    @Test
    void testCreateProject() {
        Project project = ProjectTestHelper.createTestProject();
        projectService.createProject(project);
        verify(projectRepository).saveProject(project);
    }

    @Test
    void testUpdateProject() {
        Project project = ProjectTestHelper.createTestProject();
        when(projectRepository.findProject(project.getId())).thenReturn(project);
        projectService.updateProject(project);
        verify(projectRepository).saveProject(project);
    }

    @Test
    void testUpdateProjectShouldThrowExceptionWhenNoExistingProject() {
        Project project = ProjectTestHelper.createTestProject();
        when(projectRepository.findProject(project.getId())).thenReturn(null);
        assertThrows(RuntimeException.class, () -> projectService.updateProject(project));
    }

    @Test
    void testDeleteProject() {
        Project project = ProjectTestHelper.createTestProject();
        when(projectRepository.findProject(1)).thenReturn(project);
        projectService.deleteProject(1);
        verify(projectRepository).removeProject(1);
    }

    @Test
    void testDeleteProjectShouldThrowExceptionWhenNoExistingProject() {
        when(projectRepository.findProject(1)).thenReturn(null);
        assertThrows(RuntimeException.class, () -> projectService.deleteProject(1));
    }
}
