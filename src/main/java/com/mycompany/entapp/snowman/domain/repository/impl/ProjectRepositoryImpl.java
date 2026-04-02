package com.mycompany.entapp.snowman.domain.repository.impl;

import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.repository.ProjectRepository;
import com.mycompany.entapp.snowman.infrastructure.db.jpa.ProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    @Autowired
    private ProjectJpaRepository projectJpaRepository;

    @Override
    public Project findProject(int projectId) {
        return projectJpaRepository.findById(projectId).orElse(null);
    }

    @Override
    public void saveProject(Project project) {
        projectJpaRepository.save(project);
    }

    @Override
    public void removeProject(int projectId) {
        projectJpaRepository.deleteById(projectId);
    }
}
