package com.teamsamuelsagar.coworkingspace.billing.service;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.billing.entity.User;
import com.teamsamuelsagar.coworkingspace.billing.repository.UserRepository;

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
