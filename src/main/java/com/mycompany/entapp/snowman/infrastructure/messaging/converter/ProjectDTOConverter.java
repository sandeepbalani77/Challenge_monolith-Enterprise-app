package com.mycompany.entapp.snowman.infrastructure.messaging.converter;

import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.messaging.dto.ProjectDTO;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class ProjectDTOConverter {

    private ProjectDTOConverter() {
    }

    public static ProjectDTO convertToProjectDTO(Project project) {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectId(project.getId());
        projectDTO.setProjectTitle(project.getProjectTitle());
        projectDTO.setDateStarted(toDate(project.getDateStarted()));
        projectDTO.setDateEnded(toDate(project.getDateEnded()));
        return projectDTO;
    }

    public static Set<ProjectDTO> convertToProjectDTOS(Set<Project> projects) {
        Set<ProjectDTO> projectDTOSet = new HashSet<>();
        if (projects != null) {
            for (Project project : projects) {
                projectDTOSet.add(convertToProjectDTO(project));
            }
        }
        return projectDTOSet;
    }

    private static Date toDate(LocalDate localDate) {
        if (localDate == null) return null;
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
