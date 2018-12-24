package com.task2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.task2.model.User;
import com.task2.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/api/users")
    public List<User> getUsers() {
        List<User> users = userService.allUsers();
        return users;
    }

    @GetMapping("/api/users/{email}")
    public User getUser(@PathVariable(name = "email") String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/api/users")
    public void saveEmployee(User user) {
        userService.saveUser(user);
        System.out.println("User Saved Successfully");
    }

    @DeleteMapping("/api/users/{userId}")
    public void deleteEmployee(@PathVariable(name = "userId") Long userId) {
        userService.deleteUser(userId);
        System.out.println("User Deleted Successfully");
    }

    @PutMapping("/api/users/{userId}")
    public void updateEmployee(@RequestBody User user,
                               @PathVariable(name = "userId") Long userId) {
        User oldUser = userService.getUserById(userId);
        if (oldUser != null) {
            userService.updateUser(user);
        }
    }
}

