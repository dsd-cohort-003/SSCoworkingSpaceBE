package com.teamsamuelsagar.coworkingspace.service;

import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.model.User;
import com.teamsamuelsagar.coworkingspace.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;

    public ReservationService(ReservationRepository reservationRepository, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    public Reservation getReservationByConfirmationNumber(String confirmationNumber) {
        return reservationRepository.findByConfirmationNumber(confirmationNumber);
    }

    public Reservation createNewReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationRepository.findAllReservationsByUserId(userId);
    }

    public List<Reservation> getReservationsByUUID(UUID authUserId) {
        User foundUser = userService.getUserByAuthUserId(authUserId);

        return getReservationsByUserId(foundUser.getId());
    }
}
