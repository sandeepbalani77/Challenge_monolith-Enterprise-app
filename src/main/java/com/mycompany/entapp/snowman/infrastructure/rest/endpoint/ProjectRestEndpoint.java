package com.mycompany.entapp.snowman.infrastructure.rest.endpoint;

import com.mycompany.entapp.snowman.domain.model.Project;
import com.mycompany.entapp.snowman.domain.service.ProjectService;
import com.mycompany.entapp.snowman.infrastructure.rest.mappers.ProjectResourceMapper;
import com.mycompany.entapp.snowman.infrastructure.rest.resources.ProjectResource;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectRestEndpoint {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResource> getProject(@PathVariable int projectId) {
        Project project = projectService.getProject(projectId);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ProjectResourceMapper.mapToProjectResource(project));
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createProject(@Valid @RequestBody ProjectResource projectResource) {
        projectService.createProject(ProjectResourceMapper.mapToProject(projectResource));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateProject(@Valid @RequestBody ProjectResource projectResource) {
        projectService.updateProject(ProjectResourceMapper.mapToProject(projectResource));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(@PathVariable int projectId) {
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }
}
