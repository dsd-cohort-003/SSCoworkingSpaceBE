package com.teamsamuelsagar.coworkingspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.Office;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long> {}

