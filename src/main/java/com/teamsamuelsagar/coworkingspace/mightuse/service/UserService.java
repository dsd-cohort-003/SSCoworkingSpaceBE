package com.teamsamuelsagar.coworkingspace.mightuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.mightuse.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String getAllUsers() {
        // Logic to retrieve all users
        return "List of all users";
    }
        
}
