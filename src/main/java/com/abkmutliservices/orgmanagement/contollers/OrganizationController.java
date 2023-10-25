package com.abkmutliservices.orgmanagement.contollers;

import com.abkmutliservices.orgmanagement.entities.Organization;
import com.abkmutliservices.orgmanagement.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/organizations")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;
    @GetMapping
    public ResponseEntity<List<Organization>> getAllOrganizations(){
        List<Organization> organizationList = organizationService.getAllOrganization();
        return new ResponseEntity<>(organizationList, HttpStatus.OK);
    }
    @GetMapping("/{organizationId}")
    public ResponseEntity<Organization> getOragnizationById(@PathVariable Integer organizationId){
        Organization organization = organizationService.getOrganizationById(organizationId);
        return new ResponseEntity<>(organization, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Organization> createOragnization(@RequestBody Organization organization){
        Organization newOrganization = organizationService.createOrganization(organization);
        return new ResponseEntity<>(newOrganization, HttpStatus.CREATED);
    }
}
