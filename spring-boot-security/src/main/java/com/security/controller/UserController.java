package com.security.controller;

import com.security.model.User;
import com.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    //get all users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    // single user
    @GetMapping("/{username}")
    public User getUser(@PathVariable("username") String username){
        return this.userService.getUser(username);
    }

    // Add user
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/adduser")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }
}
