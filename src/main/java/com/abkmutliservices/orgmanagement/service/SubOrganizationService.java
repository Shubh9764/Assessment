package com.abkmutliservices.orgmanagement.service;

import com.abkmutliservices.orgmanagement.dto.SubOrganizationCreateRequest;
import com.abkmutliservices.orgmanagement.entities.SubOrganization;

import java.util.List;

public interface SubOrganizationService {
    public SubOrganization createSubOrganization(SubOrganizationCreateRequest subOrganizationCreateRequest);
    public List<SubOrganization> getAllSubOrganization();

    public SubOrganization getSubOrganizationById(Integer subOrganizationId);
}
