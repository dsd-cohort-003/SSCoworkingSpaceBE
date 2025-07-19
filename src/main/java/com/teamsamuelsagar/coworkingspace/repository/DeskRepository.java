package com.teamsamuelsagar.coworkingspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.entity.Desk;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Integer> {
    public Desk findById(int id);
}
