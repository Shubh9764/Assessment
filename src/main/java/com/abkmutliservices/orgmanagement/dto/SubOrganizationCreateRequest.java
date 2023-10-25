package com.abkmutliservices.orgmanagement.dto;

import com.abkmutliservices.orgmanagement.entities.SubOrganization;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubOrganizationCreateRequest {
    @NotNull(message = "subOrganization must not be null")
    SubOrganization subOrganization;
    @NotNull(message = "organizationId must not be null")
    Integer organizationId;
}
