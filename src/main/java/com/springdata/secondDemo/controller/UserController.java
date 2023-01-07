package com.springdata.secondDemo.controller;

import com.springdata.secondDemo.model.dto.UserDTO;
import com.springdata.secondDemo.model.dto.UserDTO;
import com.springdata.secondDemo.model.entity.User;
import com.springdata.secondDemo.service.UserService;
import com.springdata.secondDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get-user")
    public UserDTO getUserById(@RequestParam Integer id){
        return userService.getUserById(id);
    }

    @PostMapping("/add-user")
    public UserDTO addUser(@RequestBody UserDTO user){
        return userService.addUser(user);
    }

    @PostMapping("/update-user")
    public UserDTO updateUser(@RequestBody UserDTO User){
        return userService.updateUser(User);
    }

    @GetMapping("/get-all-user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/delete-user")
    public void deleteUser(@RequestParam Integer id){
        userService.deleteUser(id);
    }



}
