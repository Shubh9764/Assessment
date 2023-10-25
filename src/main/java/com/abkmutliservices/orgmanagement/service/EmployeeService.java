package com.abkmutliservices.orgmanagement.service;

import com.abkmutliservices.orgmanagement.dto.EmployeeCreateRequest;
import com.abkmutliservices.orgmanagement.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(EmployeeCreateRequest employeeCreateRequest);
    public Employee getEmployeeById(Integer employeeId);

    public Employee updateEmployeeById(Employee newEmployee,Integer employeeId);

    public List<Employee> getAllEmployees();

    public String deleteEmployeeById(Integer employeeId);
}
