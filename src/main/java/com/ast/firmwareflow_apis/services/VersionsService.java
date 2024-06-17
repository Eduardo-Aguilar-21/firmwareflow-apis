package com.ast.firmwareflow_apis.services;

import com.ast.firmwareflow_apis.models.VersionsModel;
import com.ast.firmwareflow_apis.repositories.VersionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VersionsService {
    @Autowired
    private VersionsRepository versionsRepository;

    public List<VersionsModel> getAll(){
        return versionsRepository.findAll();
    }

    public Optional<VersionsModel> getById(Long id){
        return versionsRepository.findById(id);
    }

    public List<VersionsModel> findByProject(Long projectId){
        return versionsRepository.findByProjectsModelId(projectId);
    }

    public Page<VersionsModel> findByProject(Long projectId, Pageable pageable){
        return versionsRepository.findByProyectsModelId(projectId, pageable);
    }

    public VersionsModel save(VersionsModel versionsModel){
        return versionsRepository.save(versionsModel);
    }

    public VersionsModel edit(Long id, VersionsModel versionsModel){
        Optional<VersionsModel> existing = versionsRepository.findById(id);
        if (existing.isPresent()) {
            VersionsModel data = existing.get();
            data.setName(versionsModel.getName());
            return versionsRepository.save(data);
        }
        return null;
    }

    public void detele(Long id){
        versionsRepository.deleteById(id);
    }
}
