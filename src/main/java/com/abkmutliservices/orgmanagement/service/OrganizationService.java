package com.abkmutliservices.orgmanagement.service;


import com.abkmutliservices.orgmanagement.entities.Organization;

import java.util.List;

public interface OrganizationService {

    public Organization createOrganization(Organization organizationDto);
    public List<Organization> getAllOrganization();

    public Organization getOrganizationById(Integer organizationId);
}
