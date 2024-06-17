package com.ast.firmwareflow_apis.controllers;

import com.ast.firmwareflow_apis.models.ProjectsModel;
import com.ast.firmwareflow_apis.services.ProjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/projects")
public class ProjectsController {
    @Autowired
    private ProjectsService projectsService;

    @GetMapping
    public List<ProjectsModel> getAll(){
        return projectsService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<ProjectsModel> getById(@PathVariable Long id){
        return projectsService.getById(id);
    }

    @PostMapping
    public ResponseEntity<ProjectsModel> save(@RequestBody ProjectsModel projectsModel){
        ProjectsModel data = projectsService.save(projectsModel);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectsModel> edit(@PathVariable Long id, @RequestBody ProjectsModel projectsModel){
        ProjectsModel data = projectsService.edit(id, projectsModel);
        if(data != null) {
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectsModel> delete(@PathVariable Long id){
        projectsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
