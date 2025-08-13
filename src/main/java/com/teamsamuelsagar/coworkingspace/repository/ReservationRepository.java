package com.teamsamuelsagar.coworkingspace.repository;

import com.teamsamuelsagar.coworkingspace.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    Reservation findByConfirmationNumber(String confirmationNumber);

    List<Reservation> findAllReservationsByUserId(Long userId);

}
