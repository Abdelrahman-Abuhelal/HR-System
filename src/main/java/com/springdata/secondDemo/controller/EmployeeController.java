package com.springdata.secondDemo.controller;

import com.springdata.secondDemo.model.dto.DepartmentDTO;
import com.springdata.secondDemo.model.dto.EmployeeDTO;
import com.springdata.secondDemo.model.entity.Department;
import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.model.entity.Role;
import com.springdata.secondDemo.model.entity.User;
import com.springdata.secondDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/{empId}")
    public EmployeeDTO getEmployee(@PathVariable Integer empId){
        return empService.getEmployee(empId);
    }

    @PostMapping("/add-emp")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employee){
        return empService.addEmployee(employee);
    }

    @PutMapping("/update-emp")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employee){
        return empService.updateEmployee(employee);
    }

    @GetMapping("")
    public List<Employee> getAllEmployee(){
        return empService.getAllEmployees();
    }


    @GetMapping("/delete-emp/{empId}")
    public void deleteEmployee(@PathVariable Integer empId){
         empService.deleteEmployee(empId);
    }


    @GetMapping("/department/{deptId}")
    public List<Employee> findByDepartmentId(@PathVariable Integer deptId){
        return empService.findByDepartmentId(deptId);
    }

    @GetMapping("/user/{userId}")
    public List<Employee> findByUserId(@PathVariable Integer userId){
        return empService.findByUserId(userId);
    }


    @GetMapping("/assistant")
    public List<Employee> getAllAssistant() {
        return empService.findAllAssistants();
    }

    @GetMapping("/manager")
    public List<Employee> getAllManagers(){
        return empService.findAllManagers();
    }


    @GetMapping("/ceo")
    public List<Employee> getCEO(){
        return empService.findCEO();
    }

    @PutMapping("/{empId}/department")
    public EmployeeDTO addDepartmentToEmployee(@PathVariable Integer empId, @RequestBody DepartmentDTO departmentDTO){
       return empService.addDepartmentToEmployee(empId,departmentDTO);
    }

}

