package com.abkmutliservices.orgmanagement.repo;

import com.abkmutliservices.orgmanagement.entities.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepo extends JpaRepository<Organization,Integer> {
}
