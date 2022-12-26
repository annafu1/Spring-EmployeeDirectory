package io.zipcoder.persistenceapp.controllers;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/API/employee-controller")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @PostMapping(value = "/employee")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<Employee> read( @PathVariable Long employeeId) {
        return new ResponseEntity<>(service.read(employeeId), HttpStatus.OK);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long employeeId, @RequestBody Employee newEmployeeData) {
        return new ResponseEntity<>(service.update(employeeId, newEmployeeData), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Employee> delete(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.delete(employee), HttpStatus.OK);
    }

}
