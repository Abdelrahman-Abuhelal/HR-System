package com.springdata.secondDemo.service;

import com.springdata.secondDemo.model.dto.DepartmentDTO;
import com.springdata.secondDemo.model.dto.EmployeeDTO;
import com.springdata.secondDemo.model.entity.Department;
import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.model.entity.Role;
import com.springdata.secondDemo.repository.DepartmentRepository;
import com.springdata.secondDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;


    public DepartmentDTO getDepartment(Integer id){
        Department department = this.departmentRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("The department with the id provided is not existed"));
        return DepartmentDTO.toDTO(department);
    }

    public DepartmentDTO addDepartment(DepartmentDTO department){
        return DepartmentDTO.toDTO(departmentRepository.save(Department.toDepartment(department)));
    }

    public void deleteDepartment(Integer id){
        this.departmentRepository.deleteById(id);
    }

    public DepartmentDTO updateDepartment(DepartmentDTO department) {
        return DepartmentDTO.toDTO(departmentRepository.save(Department.toDepartment(department)));
    }

    public List<Department> getAllDepartment() {
        return this.departmentRepository.findAll();
    }

    public DepartmentDTO addManagerToDepartment(Integer deptId, Employee manager){
        Department department =departmentRepository.findById(deptId).orElseThrow(()->new EntityNotFoundException());
        department.setManager(manager);
        Employee employee =employeeRepository.findById(manager.getId()).orElseThrow(()->new EntityNotFoundException());
        employee.setRole(Role.MANAGER);
        employee.setDepartment(department);
        return DepartmentDTO.toDTO(departmentRepository.save(department));
    }

}

