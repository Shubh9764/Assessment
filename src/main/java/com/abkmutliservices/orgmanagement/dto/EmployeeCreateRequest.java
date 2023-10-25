package com.abkmutliservices.orgmanagement.dto;

import com.abkmutliservices.orgmanagement.entities.Employee;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeCreateRequest {
    @Valid
    @NotNull(message = "employee must not be null")
    private Employee employee;
    @NotNull(message = "organizationId must not be null")
    private Integer suborganizationId;
    @NotNull(message = "departmentId must not be null")
    private Integer departmentId;
    @NotNull(message = "roleId must not be null")
    private Integer roleId;

}
