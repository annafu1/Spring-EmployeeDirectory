package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/API/dept-controller")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @PostMapping(value = "/department")
    public ResponseEntity<Department> create (@RequestBody Department department) {
        return new ResponseEntity<>(service.create(department), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Department> read(@PathVariable Long deptId) {
        return new ResponseEntity<>(service.read(deptId), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Department> update(@PathVariable Long deptId, @RequestBody Department newDepartmentData) {
        return new ResponseEntity<>(service.update(deptId, newDepartmentData), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Department> delete(@RequestBody Department department) {
        return  new ResponseEntity<>(service.delete(department), HttpStatus.OK);
    }

}
