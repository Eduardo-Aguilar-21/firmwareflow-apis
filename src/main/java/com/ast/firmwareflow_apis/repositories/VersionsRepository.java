package com.ast.firmwareflow_apis.repositories;

import com.ast.firmwareflow_apis.models.VersionsModel;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VersionsRepository extends JpaRepository<VersionsModel, Long> {
    List<VersionsModel> findByProjectsModelId(Long projectId);

    Page<VersionsModel> findByProyectsModelId(Long projectId, Pageable pageable);
}
