package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.ProjectTestHelper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.ProjectJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectRepositoryImplUTest {

    @Mock
    private ProjectJpaRepository projectJpaRepository;

    @InjectMocks
    private ProjectRepositoryImpl projectRepository;

    @Test
    void testFindProject() {
        Project project = ProjectTestHelper.createTestProject();
        when(projectJpaRepository.findById(1)).thenReturn(Optional.of(project));
        assertEquals(project, projectRepository.findProject(1));
    }

    @Test
    void testFindProjectNotFound() {
        when(projectJpaRepository.findById(99)).thenReturn(Optional.empty());
        assertNull(projectRepository.findProject(99));
    }

    @Test
    void testSaveProject() {
        Project project = ProjectTestHelper.createTestProject();
        projectRepository.saveProject(project);
        verify(projectJpaRepository).save(project);
    }

    @Test
    void testRemoveProject() {
        projectRepository.removeProject(1);
        verify(projectJpaRepository).deleteById(1);
    }
}
