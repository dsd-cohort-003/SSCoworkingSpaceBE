package com.teamsamuelsagar.coworkingspace.repository;

import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeskReservationRepository extends JpaRepository<DeskReservation, Long> {

    DeskReservation findByReservationId(Long id);
}
