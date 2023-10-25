package com.abkmutliservices.orgmanagement.contollers;

import com.abkmutliservices.orgmanagement.dto.EmployeeCreateRequest;
import com.abkmutliservices.orgmanagement.entities.Employee;
import com.abkmutliservices.orgmanagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeCreateRequest employeeCreateRequest){
        Employee newEmployee = employeeService.createEmployee(employeeCreateRequest);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee,@PathVariable Integer employeeId){
        Employee updatedEmployee = employeeService.updateEmployeeById(employee,employeeId);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId){
        String message = employeeService.deleteEmployeeById(employeeId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer employeeId){
        Employee employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
