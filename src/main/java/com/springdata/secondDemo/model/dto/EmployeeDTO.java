package com.springdata.secondDemo.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springdata.secondDemo.model.entity.Department;
import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.model.entity.Role;
import com.springdata.secondDemo.model.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

        private Integer id;
        private String firstName;
        private String lastName;
        private Double salary;
        private Date birthDate;
        private Department department;
        @JsonIgnore
        private User user;
        private Role role;


    public static EmployeeDTO toDTO(Employee employee){
            return EmployeeDTO.builder()
                    .id(employee.getId())
                    .firstName(employee.getFirstName())
                    .lastName(employee.getLastName())
                    .salary(employee.getSalary())
                    .birthDate(employee.getBirthDate())
                    .department(employee.getDepartment())
                    .role(employee.getRole())
                    .user(employee.getUser())
                    .build();
        }


    }
