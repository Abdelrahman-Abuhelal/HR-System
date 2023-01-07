package com.springdata.secondDemo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springdata.secondDemo.model.dto.DepartmentDTO;
import com.springdata.secondDemo.model.dto.EmployeeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Table
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private List<Employee> employees;
    @OneToOne
    @JsonIgnore
    private Employee manager;

    public static Department toDepartment(DepartmentDTO departmentDTO){
        return Department.builder()
                .id(departmentDTO.getId())
                .name(departmentDTO.getName())
                .employees(departmentDTO.getEmployees()).
                manager(departmentDTO.getManager())
                .build();
    }
}
