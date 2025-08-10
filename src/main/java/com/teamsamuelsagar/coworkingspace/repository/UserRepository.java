package com.teamsamuelsagar.coworkingspace.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    public Optional<User> findById(Long id);
}