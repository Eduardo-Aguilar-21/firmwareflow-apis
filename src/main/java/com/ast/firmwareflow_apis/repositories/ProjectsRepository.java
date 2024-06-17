package com.ast.firmwareflow_apis.repositories;

import com.ast.firmwareflow_apis.models.ProjectsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends JpaRepository<ProjectsModel, Long> {
}
