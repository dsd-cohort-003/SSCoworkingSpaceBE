package com.teamsamuelsagar.coworkingspace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.entity.OfficeReservation;

@Repository
public interface OfficeReservationRepository extends JpaRepository<OfficeReservation, Long> {}
