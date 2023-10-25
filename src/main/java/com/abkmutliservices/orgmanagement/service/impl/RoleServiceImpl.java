package com.abkmutliservices.orgmanagement.service.impl;

import com.abkmutliservices.orgmanagement.entities.Employee;
import com.abkmutliservices.orgmanagement.entities.Role;
import com.abkmutliservices.orgmanagement.exceptions.MySQLIntegrityConstraintViolationException;
import com.abkmutliservices.orgmanagement.exceptions.ResourceNotFoundException;
import com.abkmutliservices.orgmanagement.repo.EmployeeRepo;
import com.abkmutliservices.orgmanagement.repo.RoleRepo;
import com.abkmutliservices.orgmanagement.service.RoleService;
import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepo roleRepo;

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Role createRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepo.findAll();
    }

    @Override
    public Role getRoleById(Integer roleId) {
        return roleRepo.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role with id "+roleId +" does not exists"));
    }

    @Override
    public Role updateRole(Role newRole, Integer roleId) {
        Role oldRole = roleRepo.findById(roleId).orElseThrow(() -> new ResourceNotFoundException("Role with id "+roleId +" does not exists"));
        oldRole.setName(newRole.getName());
        return roleRepo.save(oldRole);
    }

    @Override
    public String deleteRole(Integer roleId) {
       try{
           roleRepo.deleteById(roleId);
       }
       catch (RuntimeException ex){
           throw new MySQLIntegrityConstraintViolationException("Role is associated with employees and cannot be deleted");
       }
        return "Role with id "+roleId + " deleted Successfully";
    }
}
