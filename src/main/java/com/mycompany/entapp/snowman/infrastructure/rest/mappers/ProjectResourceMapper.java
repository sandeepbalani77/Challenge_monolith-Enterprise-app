package com.mycompany.entapp.snowman.infrastructure.rest.mappers;

import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ProjectResourceMapper {

    private ProjectResourceMapper() {
    }

    public static ProjectResource mapToProjectResource(Project project) {
        ProjectResource projectResource = new ProjectResource();
        projectResource.setProjectId(project.getId());
        projectResource.setTitle(project.getProjectTitle());
        projectResource.setDateStarted(toDate(project.getDateStarted()));
        projectResource.setDateEnded(toDate(project.getDateEnded()));
        return projectResource;
    }

    public static Project mapToProject(ProjectResource projectResource) {
        Project project = new Project();
        project.setId(projectResource.getProjectId());
        project.setProjectTitle(projectResource.getTitle());
        project.setDateStarted(toLocalDate(projectResource.getDateStarted()));
        project.setDateEnded(toLocalDate(projectResource.getDateEnded()));
        return project;
    }

    public static List<ProjectResource> mapToProjectResources(Set<Project> projects) {
        if (projects == null) {
            return new ArrayList<>();
        }
        List<ProjectResource> projectResources = new ArrayList<>();
        for (Project project : projects) {
            projectResources.add(mapToProjectResource(project));
        }
        return projectResources;
    }

    public static Set<Project> mapToProjects(List<ProjectResource> projectResources) {
        if (projectResources == null) {
            return new HashSet<>();
        }
        Set<Project> projects = new HashSet<>();
        for (ProjectResource projectResource : projectResources) {
            projects.add(mapToProject(projectResource));
        }
        return projects;
    }

    private static Date toDate(LocalDate localDate) {
        if (localDate == null) return null;
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    private static LocalDate toLocalDate(Date date) {
        if (date == null) return null;
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
