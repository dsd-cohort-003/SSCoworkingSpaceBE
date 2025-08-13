package com.teamsamuelsagar.coworkingspace.repository;

import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DeskReservationRepository extends JpaRepository<DeskReservation, Long> {

    @Query("SELECT dr FROM DeskReservation dr WHERE dr.startDate <= :today ")
    public List<DeskReservation> findCurrentReservations(@Param("today") LocalDate today);

}
