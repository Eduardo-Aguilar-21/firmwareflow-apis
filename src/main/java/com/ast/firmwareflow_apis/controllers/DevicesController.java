package com.ast.firmwareflow_apis.controllers;

import com.ast.firmwareflow_apis.models.DevicesModel;
import com.ast.firmwareflow_apis.services.DevicesService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "api/devices")
public class DevicesController {
    @Autowired
    private DevicesService devicesService;

    @GetMapping
    public List<DevicesModel> getAll(){
        return devicesService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<DevicesModel> getById(@PathVariable Long id){
        return devicesService.getBytId(id);
    }

    @PostMapping
    public ResponseEntity<DevicesModel> save(@RequestBody DevicesModel devicesModel){
        DevicesModel data = devicesService.save(devicesModel);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DevicesModel> edit(@PathVariable Long id, @RequestBody DevicesModel devicesModel){
        DevicesModel data = devicesService.edit(id, devicesModel);
        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DevicesModel> delete(@PathVariable Long id){
        devicesService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
