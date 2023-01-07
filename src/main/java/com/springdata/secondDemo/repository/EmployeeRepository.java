package com.springdata.secondDemo.repository;

import com.springdata.secondDemo.model.dto.EmployeeDTO;
import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.model.entity.Role;
import com.springdata.secondDemo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

//    Employee addByRole(Role role);

    List<Employee>findByDepartmentId(Integer deptId);

    List<Employee> findByUserId(Integer deptId);


    List<Employee> findByRole(Role role);

}
