package com.abkmutliservices.orgmanagement.service;
import com.abkmutliservices.orgmanagement.entities.Role;

import java.util.List;

public interface RoleService {

    public Role createRole(Role role);
    public List<Role> getAllRoles();

    public Role getRoleById(Integer roleId);

    public Role updateRole(Role newRole, Integer roleId);

    public String deleteRole(Integer roleId);

}
