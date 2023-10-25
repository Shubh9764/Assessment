package com.abkmutliservices.orgmanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abkmutliservices.orgmanagement.entities.Role;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role,Integer> {

    Optional<Role> findByName(String name);
}
