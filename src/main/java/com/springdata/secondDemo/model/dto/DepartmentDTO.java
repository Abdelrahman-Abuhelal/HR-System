package com.springdata.secondDemo.model.dto;

import com.springdata.secondDemo.model.entity.Department;
import com.springdata.secondDemo.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Integer id;
    private String name;
    private List<Employee> employees;
    private Employee manager;



    public static DepartmentDTO toDTO(Department department){
        return DepartmentDTO.builder()
                .id(department.getId())
                .name(department.getName())
                .employees(department.getEmployees())
                .manager(department.getManager())
                .build();
    }




}
