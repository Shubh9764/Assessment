package com.abkmutliservices.orgmanagement.service;

import com.abkmutliservices.orgmanagement.entities.Department;

import java.util.List;

public interface DepartmentService {

    public Department createDepartment(Department department);
    public Department getDepartmentById(Integer departmentId);

    public Department updateDepartmentById(Department newDepartment,Integer departmentId);

    public List<Department> getAllDepartments();

    public String deleteDepartmentById(Integer departmentId);
}
