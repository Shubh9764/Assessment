package com.abkmutliservices.orgmanagement.service.impl;

import com.abkmutliservices.orgmanagement.entities.Organization;
import com.abkmutliservices.orgmanagement.entities.SubOrganization;
import com.abkmutliservices.orgmanagement.repo.OrganizationRepo;
import com.abkmutliservices.orgmanagement.repo.SubOrganizationRepo;
import com.abkmutliservices.orgmanagement.service.SubOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubOrganizationServiceImpl implements SubOrganizationService {

    @Autowired
    SubOrganizationRepo subOrganizationRepo;
    @Autowired
    OrganizationRepo organizationRepo;

    @Override
    public SubOrganization createSubOrganization(SubOrganization subOrganization,Integer organizationId) {
        Organization organization = organizationRepo.findById(organizationId).orElseThrow(() -> new RuntimeException("Organization with id "+organizationId +"does not exists"));
        subOrganization.setOrganization(organization);
        return subOrganizationRepo.save(subOrganization);
    }

    @Override
    public List<SubOrganization> getAllSubOrganization() {
        return subOrganizationRepo.findAll();
    }

    @Override
    public SubOrganization getSubOrganizationById(Integer subOrganizationId) {
        return subOrganizationRepo.findById(subOrganizationId).orElseThrow(() -> new RuntimeException("SubOrganization with id "+subOrganizationId +"does not exists"));
    }
}
