package com.teamsamuelsagar.coworkingspace.service;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.entity.User;
import com.teamsamuelsagar.coworkingspace.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
