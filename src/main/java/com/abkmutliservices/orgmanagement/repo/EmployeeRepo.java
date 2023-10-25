package com.abkmutliservices.orgmanagement.repo;

import com.abkmutliservices.orgmanagement.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByEmail(String email);
    Optional<Employee> findByMobileNumber(String mobileNumber);
}
