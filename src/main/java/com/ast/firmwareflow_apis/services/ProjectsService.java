package com.ast.firmwareflow_apis.services;

import com.ast.firmwareflow_apis.models.ProjectsModel;
import com.ast.firmwareflow_apis.repositories.ProjectsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectsService {
    @Autowired
    private ProjectsRepository projectsRepository;

    public List<ProjectsModel> getAll(){
        return projectsRepository.findAll();
    }

    public Optional<ProjectsModel> getById(Long id){
        return projectsRepository.findById(id);
    }

    public ProjectsModel save(ProjectsModel projectsModel){
        return projectsRepository.save(projectsModel);
    }

    public ProjectsModel edit(Long id, ProjectsModel projectsModel){
        Optional<ProjectsModel> existing = projectsRepository.findById(id);

        if (existing.isPresent()){
            ProjectsModel data = existing.get();
            data.setName(projectsModel.getName());
            return projectsRepository.save(data);
        }
        return null;
    }

    public void delete(Long id){
        projectsRepository.deleteById(id);
    }
}
