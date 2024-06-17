package com.ast.firmwareflow_apis.services;

import com.ast.firmwareflow_apis.models.DevicesModel;
import com.ast.firmwareflow_apis.repositories.DevicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class DevicesService {
    @Autowired
    private DevicesRepository devicesRepository;

    public List<DevicesModel> getAll(){
        return devicesRepository.findAll();
    }

    public Optional<DevicesModel> getBytId(Long id){
        return devicesRepository.findById(id);
    }

    public DevicesModel save(DevicesModel devicesModel){
        return devicesRepository.save(devicesModel);
    }

    public DevicesModel edit(Long id, DevicesModel devicesModel ){
        Optional<DevicesModel> existing = devicesRepository.findById(id);
        if (existing.isPresent()){
            DevicesModel data = existing.get();
            data.setName(devicesModel.getName());
            data.setProjectsModel(devicesModel.getProjectsModel());
            return devicesRepository.save(data);
        }
        return null;
    }

    public void delete(Long id){
        devicesRepository.deleteById(id);
    }
}
