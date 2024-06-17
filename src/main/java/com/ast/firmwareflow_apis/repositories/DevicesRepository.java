package com.ast.firmwareflow_apis.repositories;

import com.ast.firmwareflow_apis.models.DevicesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DevicesRepository extends JpaRepository<DevicesModel, Long> {
}
