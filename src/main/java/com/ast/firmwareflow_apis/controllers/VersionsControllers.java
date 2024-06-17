package com.ast.firmwareflow_apis.controllers;

import com.ast.firmwareflow_apis.models.VersionsModel;
import com.ast.firmwareflow_apis.services.VersionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/versions")
public class VersionsControllers {
    @Autowired
    private VersionsService versionsServices;

    @GetMapping
    public List<VersionsModel> getAll(){
        return versionsServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<VersionsModel> getById(@PathVariable Long id){
        return versionsServices.getById(id);
    }

    @GetMapping("/xproject/{id}")
    public ResponseEntity<List<VersionsModel>>findByProyect(@PathVariable Long id){
        List<VersionsModel> data = versionsServices.findByProject(id);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @GetMapping("/xproject-page/{id}")
    public ResponseEntity<Page<VersionsModel>>findByProyectPage(@PathVariable Long id,
                                                      @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<VersionsModel> data = versionsServices.findByProject(id, pageable);
        return new ResponseEntity<>(data,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VersionsModel> save(@RequestBody VersionsModel versionsModel){
        VersionsModel data = versionsServices.save(versionsModel);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VersionsModel> edit(@PathVariable Long id, @RequestBody VersionsModel versionsModel) {
        VersionsModel data = versionsServices.edit(id, versionsModel);
        if (data != null){
            return new ResponseEntity<>(data, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VersionsModel> delete(@PathVariable Long id){
        versionsServices.detele(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
