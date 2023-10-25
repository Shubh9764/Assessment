package com.abkmutliservices.orgmanagement.repo;

import com.abkmutliservices.orgmanagement.entities.Department;
import com.abkmutliservices.orgmanagement.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    Optional<Department> findByName(String name);
}
