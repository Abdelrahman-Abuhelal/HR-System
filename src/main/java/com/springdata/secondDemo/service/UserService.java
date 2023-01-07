package com.springdata.secondDemo.service;

import com.springdata.secondDemo.model.dto.EmployeeDTO;
import com.springdata.secondDemo.model.dto.UserDTO;
import com.springdata.secondDemo.model.entity.Employee;
import com.springdata.secondDemo.model.entity.User;
import com.springdata.secondDemo.repository.EmployeeRepository;
import com.springdata.secondDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserById(Integer id){
        Optional<User> user= this.userRepository.findById(id);
        return UserDTO.toDTO(user.orElse(null));
    }

    public UserDTO addUser(UserDTO user){
        return UserDTO.toDTO(userRepository.save(User.toUser(user)));
    }

    public void deleteUser(Integer id){
        this.userRepository.deleteById(id);
    }

    public UserDTO updateUser(UserDTO user) {
        return UserDTO.toDTO(userRepository.save(User.toUser(user)));
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }


}
