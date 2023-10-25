package com.abkmutliservices.orgmanagement.service.impl;

import com.abkmutliservices.orgmanagement.entities.Department;
import com.abkmutliservices.orgmanagement.exceptions.MySQLIntegrityConstraintViolationException;
import com.abkmutliservices.orgmanagement.repo.DepartmentRepo;
import com.abkmutliservices.orgmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepo departmentRepo;
    @Override
    public Department createDepartment(Department department) {
        return departmentRepo.save(department);
    }

    @Override
    public Department getDepartmentById(Integer departmentId) {
        return departmentRepo.findById(departmentId).orElseThrow(() -> new RuntimeException("Department with id "+departmentId +" does not exists"));
    }

    @Override
    public Department updateDepartmentById(Department newDepartment, Integer departmentId) {
        Department oldDepartment = getDepartmentById(departmentId);
        oldDepartment.setName(newDepartment.getName());
        return departmentRepo.save(oldDepartment);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public String deleteDepartmentById(Integer departmentId) {
        try{
            departmentRepo.deleteById(departmentId);
        }
        catch (RuntimeException ex){
           throw new MySQLIntegrityConstraintViolationException("Department is associated with employees and cannot be deleted");
        }
        return "Department with id "+departmentId + " deleted Successfully";
    }
}
