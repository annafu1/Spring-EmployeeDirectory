package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Employee;
import io.zipcoder.persistenceapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Employee read(Long employeeId) {
        return repository.findOne(employeeId);
    }

    public Iterable<Employee> index() {
        return repository.findAll();
    }

    public Employee update(Long employeeId, Employee newEmployeeData) {
        Employee originalEmployee = repository.findOne(employeeId);
        originalEmployee.setFirstName(newEmployeeData.getFirstName());
        originalEmployee.setLastName(newEmployeeData.getLastName());
        originalEmployee.setPhoneNumber(newEmployeeData.getPhoneNumber());
        originalEmployee.setEmail(newEmployeeData.getEmail());
        originalEmployee.setTitle(newEmployeeData.getTitle());
        originalEmployee.setManager(newEmployeeData.getManager());
        originalEmployee.setHireDate(newEmployeeData.getHireDate());
        return repository.save(originalEmployee);
    }

    public Employee delete(Employee employee) {
        repository.delete(employee);
        return employee;
    }

}
