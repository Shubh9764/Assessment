package com.abkmutliservices.orgmanagement.contollers;

import com.abkmutliservices.orgmanagement.dto.SubOrganizationCreateRequest;
import com.abkmutliservices.orgmanagement.entities.SubOrganization;
import com.abkmutliservices.orgmanagement.service.SubOrganizationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/suborganizations")
public class SubOrganizationController {
    @Autowired
    SubOrganizationService subOrganizationService;

    @GetMapping
    public ResponseEntity<List<SubOrganization>> getAllSubOrganizations(){
        List<SubOrganization> subOrganizations = subOrganizationService.getAllSubOrganization();
        return new ResponseEntity<>(subOrganizations, HttpStatus.OK);
    }
    @GetMapping("/{subOrganizationId}")
    public ResponseEntity<SubOrganization> getSubOrganizationById(@PathVariable Integer subOrganizationId){
        SubOrganization subOrganization = subOrganizationService.getSubOrganizationById(subOrganizationId);
        return new ResponseEntity<>(subOrganization, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<SubOrganization> createSubOrganization(@Valid @RequestBody SubOrganizationCreateRequest subOrganizationCreateRequest){
        SubOrganization newSubOrganization = subOrganizationService.createSubOrganization(subOrganizationCreateRequest);
        return new ResponseEntity<>(newSubOrganization, HttpStatus.CREATED);
    }

}
