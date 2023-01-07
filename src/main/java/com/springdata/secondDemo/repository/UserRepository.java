package com.springdata.secondDemo.repository;

import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}
