package io.zipcoder.persistenceapp;

import javax.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long deptId;
    private String deptName;
    @OneToOne
    private Employee deptManager;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Employee getDeptManager() {
        return deptManager;
    }

    public void setManager(Employee DeptManager) {
        this.deptManager = DeptManager;
    }
}
