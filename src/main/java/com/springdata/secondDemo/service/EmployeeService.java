package com.springdata.secondDemo.service;

import com.springdata.secondDemo.exception.NoDataFoundException;
import com.springdata.secondDemo.model.dto.DepartmentDTO;
import com.springdata.secondDemo.model.dto.EmployeeDTO;
import com.springdata.secondDemo.model.entity.Department;
import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.model.entity.Role;
import com.springdata.secondDemo.model.entity.User;
import com.springdata.secondDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeDTO getEmployee(Integer id){
        Employee employee= employeeRepository.findById(id)
                .orElseThrow( ()->new NoDataFoundException("no data found"));
        return EmployeeDTO.toDTO(employee);
    }

    public EmployeeDTO addEmployee(EmployeeDTO employee){
        return EmployeeDTO.toDTO(employeeRepository.save(Employee.toEmployee(employee)));
    }

    public void deleteEmployee(Integer id){
         this.employeeRepository.deleteById(id);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employee) {
        return EmployeeDTO.toDTO(employeeRepository.save(Employee.toEmployee(employee)));
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employees=  employeeRepository.findAll();
        if (employees.isEmpty()){
            throw new NoDataFoundException("there is no customers to show");
        }
        return employees;
    }

    public List<Employee>findByDepartmentId(Integer deptId){
        return employeeRepository.findByDepartmentId(deptId);
    }

    public List<Employee> findByUserId(Integer userId){
        return employeeRepository.findByUserId(userId);
    }

    public List<Employee> findAllAssistants() {
        return employeeRepository.findByRole(Role.ASSISTANT);
    }
    public List<Employee> findAllManagers() {
        return employeeRepository.findByRole(Role.MANAGER);
    }

    public List<Employee> findCEO() {
        return employeeRepository.findByRole(Role.CEO);
    }

    public EmployeeDTO addDepartmentToEmployee(Integer empId,DepartmentDTO departmentDTO){
        Employee employee=employeeRepository.findById(empId).orElseThrow(()->
                new EntityNotFoundException("Employee not found for this id ->"+empId));
        employee.setDepartment(Department.toDepartment(departmentDTO));
        return EmployeeDTO.toDTO(employeeRepository.save(employee));
    }
}
