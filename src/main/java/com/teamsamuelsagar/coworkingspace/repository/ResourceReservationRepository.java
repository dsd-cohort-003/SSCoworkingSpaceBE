package com.teamsamuelsagar.coworkingspace.repository;

import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResourceReservationRepository extends JpaRepository<ResourceReservation, Long> {
}
