package com.teamsamuelsagar.coworkingspace.repository;

import com.teamsamuelsagar.coworkingspace.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public Reservation findByConfirmationNumber(String confirmationNumber);
}
