package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.models.Department;
import io.zipcoder.persistenceapp.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department create(Department department) {
        return repository.save(department);
    }

    public Department read(Long id) {
        return repository.findOne(id);
    }

    public Iterable<Department> index() {
        return repository.findAll();
    }

    public Department update(Long id, Department newDepartmentData) {
        Department originalDepartment = repository.findOne(id);
        originalDepartment.setManager(newDepartmentData.getDeptManager());
        originalDepartment.setDeptName(newDepartmentData.getDeptName());
        return repository.save(originalDepartment);
    }

    public Department delete(Department department) {
        repository.delete(department);
        return department;
    }
}
