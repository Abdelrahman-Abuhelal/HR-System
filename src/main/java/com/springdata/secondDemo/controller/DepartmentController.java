package com.springdata.secondDemo.controller;

import com.springdata.secondDemo.model.dto.DepartmentDTO;
import com.springdata.secondDemo.model.dto.EmployeeDTO;
import com.springdata.secondDemo.model.entity.Department;
import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/{deptId}")
    public DepartmentDTO getDepartment(@PathVariable Integer deptId) throws EntityNotFoundException {
        return departmentService.getDepartment(deptId);
    }

    @PostMapping("/add-dep")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO department){
        return departmentService.addDepartment(department);
    }

    @PostMapping("/update-dep")
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO department){
        return departmentService.updateDepartment(department);
    }

    @GetMapping("/delete-dep")
    public void deleteDepartment(@RequestParam Integer id){
        departmentService.deleteDepartment(id);
}

    @GetMapping("/get-all-dep")
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }


    @PutMapping("/{deptId}/manager")
    public DepartmentDTO addManagerToDepartment(@PathVariable Integer deptId,@RequestBody EmployeeDTO employeeDTO){
        return departmentService.addManagerToDepartment(deptId, Employee.toEmployee(employeeDTO));
    }




}
