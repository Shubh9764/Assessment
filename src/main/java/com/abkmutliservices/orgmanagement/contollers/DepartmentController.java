package com.abkmutliservices.orgmanagement.contollers;

import com.abkmutliservices.orgmanagement.entities.Department;
import com.abkmutliservices.orgmanagement.entities.Role;
import com.abkmutliservices.orgmanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createRol(@RequestBody Department department){
        Department newDepartment = departmentService.createDepartment(department);
        return new ResponseEntity<>(newDepartment, HttpStatus.CREATED);
    }
    @PutMapping("/{departmentId}")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department,@PathVariable Integer departmentId){
        Department newDepartment = departmentService.updateDepartmentById(department,departmentId);
        return new ResponseEntity<>(newDepartment, HttpStatus.OK);
    }
    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer departmentId){
        Department department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartment(){
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }
    @DeleteMapping("/{departmentId}")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Integer departmentId){
        String message = departmentService.deleteDepartmentById(departmentId);
        return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
    }

}
