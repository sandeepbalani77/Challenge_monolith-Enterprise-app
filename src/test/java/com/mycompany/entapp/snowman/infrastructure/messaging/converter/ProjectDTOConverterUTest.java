package com.mycompany.entapp.snowman.infrastructure.messaging.converter;

import com.mycompany.entapp.snowman.domain.ProjectTestHelper;
import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ProjectDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDTOConverterUTest {

    @Test
    void testConvertToProjectDTO() {
        Project project = ProjectTestHelper.createTestProject();
        ProjectDTO dto = ProjectDTOConverter.convertToProjectDTO(project);
        assertEquals(project.getId(), dto.getProjectId());
        assertEquals(project.getProjectTitle(), dto.getProjectTitle());
        assertNotNull(dto.getDateStarted());
    }
}
