package com.abkmutliservices.orgmanagement.contollers;

import com.abkmutliservices.orgmanagement.entities.Role;
import com.abkmutliservices.orgmanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> createRol(@RequestBody Role role){
        Role newRole = roleService.createRole(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }
    @PutMapping("/{roleId}")
    public ResponseEntity<Role> createRol(@RequestBody Role role,@PathVariable Integer roleId){
        Role newRole = roleService.updateRole(role,roleId);
        return new ResponseEntity<>(newRole, HttpStatus.OK);
    }
    @GetMapping("/{roleId}")
    public ResponseEntity<Role> getRoleById(@PathVariable Integer roleId){
        Role role = roleService.getRoleById(roleId);
        return ResponseEntity.ok(role);
    }
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles(){
        List<Role> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }
    @DeleteMapping("/{roleId}")
    public ResponseEntity<String> deleteRoleById(@PathVariable Integer roleId){
        String message = roleService.deleteRole(roleId);
        return new ResponseEntity<>(message,HttpStatus.NO_CONTENT);
    }

}
