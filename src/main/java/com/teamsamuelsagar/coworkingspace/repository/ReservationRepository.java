package com.teamsamuelsagar.coworkingspace.repository;

import com.teamsamuelsagar.coworkingspace.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public Reservation findByConfirmationNumber(String confirmationNumber);

    public List<Reservation> findAllReservationsByUserId(Long userId);

    public List<Reservation> findAll();

    public List<Reservation> findByIsPrivate(Boolean isPrivate);
}
