package com.abkmutliservices.orgmanagement.service.impl;

import com.abkmutliservices.orgmanagement.dto.EmployeeCreateRequest;
import com.abkmutliservices.orgmanagement.entities.Department;
import com.abkmutliservices.orgmanagement.entities.Employee;
import com.abkmutliservices.orgmanagement.entities.Role;
import com.abkmutliservices.orgmanagement.entities.SubOrganization;
import com.abkmutliservices.orgmanagement.exceptions.MyUnqiueContraintException;
import com.abkmutliservices.orgmanagement.exceptions.ResourceNotFoundException;
import com.abkmutliservices.orgmanagement.repo.DepartmentRepo;
import com.abkmutliservices.orgmanagement.repo.EmployeeRepo;
import com.abkmutliservices.orgmanagement.repo.RoleRepo;
import com.abkmutliservices.orgmanagement.repo.SubOrganizationRepo;
import com.abkmutliservices.orgmanagement.service.EmployeeService;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    DepartmentRepo departmentRepo;
    @Autowired
    SubOrganizationRepo subOrganizationRepo;
    @Override
    public Employee createEmployee(EmployeeCreateRequest employeeCreateRequest) {
        Employee employee = employeeCreateRequest.getEmployee();
       if(employeeRepo.findByEmail(employee.getEmail()).isPresent()){
           throw new MyUnqiueContraintException("Email already Exists");
       }
       if(employeeRepo.findByMobileNumber(employee.getMobileNumber()).isPresent()){
           throw new MyUnqiueContraintException("Mobile Number already Exists");
       }

        SubOrganization subOrganization = subOrganizationRepo.findById(employeeCreateRequest.getSuborganizationId()).orElseThrow(() -> new RuntimeException("SubOrganization with id "+employeeCreateRequest.getSuborganizationId() +"does not exists"));
        Department department = departmentRepo.findById(employeeCreateRequest.getDepartmentId()).orElseThrow(() -> new RuntimeException("Department with id "+employeeCreateRequest.getDepartmentId() +" does not exists"));
        Role role = roleRepo.findById(employeeCreateRequest.getRoleId()).orElseThrow(() -> new ResourceNotFoundException("Role with id "+employeeCreateRequest.getRoleId() +" does not exists"));
        employee.setSubOrganization(subOrganization);
        employee.setDepartment(department);
        employee.setRole(role);
        return employeeRepo.save(employee);
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepo.findById(employeeId).orElseThrow(() ->  new ResourceNotFoundException("Emplyee with id +"+employeeId+" does not Exists"));
    }

    @Override
    public Employee updateEmployeeById(Employee newEmployee, Integer employeeId) {
        if(employeeRepo.findByEmail(newEmployee.getEmail()).isPresent()){
            throw new MyUnqiueContraintException("Email already Exists");
        }
        if(employeeRepo.findByMobileNumber(newEmployee.getMobileNumber()).isPresent()){
            throw new MyUnqiueContraintException("Mobile Number already Exists");
        }
        Employee oldEmployee = getEmployeeById(employeeId);
        oldEmployee.setName(newEmployee.getName());
        oldEmployee.setEmail(newEmployee.getEmail());
        oldEmployee.setAge(newEmployee.getAge());
        oldEmployee.setMobileNumber(newEmployee.getMobileNumber());
        return employeeRepo.save(oldEmployee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public String deleteEmployeeById(Integer employeeId) {
         employeeRepo.deleteById(employeeId);
        return "Employee with id "+employeeId +" deleted Successfully";
    }
}
