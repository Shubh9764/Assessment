package com.abkmutliservices.orgmanagement.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer id;
    @Size(min = 3, max = 50)
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Pattern(regexp = "\\d{10}",message ="Mobile number should be 10 digits")
    @Column(unique = true)
    private String mobileNumber;

    @Min(value = 18, message = "Minimum age should be 18 years")
    private Integer age;

    @ManyToOne
    private Role role;

    @ManyToOne
    @JoinTable(name = "employee_suborganization",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "suborganization_id"))
    private SubOrganization subOrganization;

    @ManyToOne
    @JoinTable(name = "employee_department",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private Department department;
}
