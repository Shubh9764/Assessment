package com.abkmutliservices.orgmanagement.service.impl;

import com.abkmutliservices.orgmanagement.entities.Organization;
import com.abkmutliservices.orgmanagement.repo.OrganizationRepo;
import com.abkmutliservices.orgmanagement.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepo organizationRepo;


    @Override
    public Organization createOrganization(Organization organization) {
        return organizationRepo.save(organization);
    }

    @Override
    public List<Organization> getAllOrganization() {
        return organizationRepo.findAll();
    }

    @Override
    public Organization getOrganizationById(Integer organizationId) {
        return organizationRepo.findById(organizationId).orElseThrow( () -> new RuntimeException("Organization with id "+organizationId +" does not exists"));
    }
}
