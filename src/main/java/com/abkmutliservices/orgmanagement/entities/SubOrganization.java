package com.abkmutliservices.orgmanagement.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubOrganization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "suborganization_organization",
            joinColumns = @JoinColumn(name = "subOrganization_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "organization_id"))
    private Organization organization;

    @OneToMany(mappedBy = "subOrganization")
    @JsonIgnore
    private List<Employee> employees;
}
