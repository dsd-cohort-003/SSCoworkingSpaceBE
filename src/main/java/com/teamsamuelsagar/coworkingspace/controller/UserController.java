package com.teamsamuelsagar.coworkingspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public ResponseEntity<String> getAllUsers() {
        String usersList = userService.getAllUsers();
        // Logic to retrieve all users
        return ResponseEntity.ok(usersList);
    }
}
