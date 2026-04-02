package com.mycompany.entapp.snowman.domain;

import com.mycompany.entapp.snowman.domain.model.Client;
import com.mycompany.entapp.snowman.domain.model.Project;

import java.time.LocalDate;

public final class ProjectTestHelper {

    private ProjectTestHelper() {}

    public static Project createTestProject() {
        Project project = new Project();
        project.setId(1);
        project.setProjectTitle("Test Project");
        project.setDateStarted(LocalDate.of(2017, 3, 15));
        return project;
    }

    public static Project createTestProject(int id, String title) {
        Project project = new Project();
        project.setId(id);
        project.setProjectTitle(title);
        project.setDateStarted(LocalDate.of(2017, 3, 15));
        return project;
    }
}
