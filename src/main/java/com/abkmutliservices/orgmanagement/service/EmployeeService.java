package com.abkmutliservices.orgmanagement.service;

import com.abkmutliservices.orgmanagement.entities.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee createEmployee(Employee employee,Integer suborganizationId,Integer departmentId,Integer roleId);
    public Employee getEmployeeById(Integer employeeId);

    public Employee updateEmployeeById(Employee newEmployee,Integer employeeId);

    public List<Employee> getAllEmployees();

    public String deleteEmployeeById(Integer employeeId);
}
