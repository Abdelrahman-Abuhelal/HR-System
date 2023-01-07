package com.springdata.secondDemo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springdata.secondDemo.model.dto.EmployeeDTO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Table
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private Date birthDate;
    private Double salary;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    @ManyToOne
    private Department department;

    @Enumerated(EnumType.STRING)
    private Role role;


    public static Employee toEmployee(EmployeeDTO employeeDTO){
        return Employee.builder()
                .id(employeeDTO.getId())
                .firstName(employeeDTO.getFirstName())
                .lastName(employeeDTO.getLastName())
                .salary(employeeDTO.getSalary())
                .birthDate(employeeDTO.getBirthDate())
                .department(employeeDTO.getDepartment())
                .role(employeeDTO.getRole())
                .user(employeeDTO.getUser())
                .build();
    }





}
