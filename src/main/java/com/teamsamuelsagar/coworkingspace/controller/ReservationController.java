package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.dto.ReservationRequestDTO;
import com.teamsamuelsagar.coworkingspace.enums.ReservationStatus;
import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.model.User;
import com.teamsamuelsagar.coworkingspace.service.ReservationService;
import com.teamsamuelsagar.coworkingspace.service.UserService;
import com.teamsamuelsagar.coworkingspace.util.ConfirmationNumberGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController {

    private final ReservationService reservationService;
    private final UserService userService;

    public ReservationController(ReservationService reservationService, UserService userService) {
        this.reservationService = reservationService;
        this.userService = userService;
    }

    @GetMapping("/reservation")
    public ResponseEntity<List<Reservation>> findAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();

        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Optional<Reservation>> findReservationById(@PathVariable String id) {
        return ResponseEntity.ok(reservationService.getReservationById(Long.parseLong(id)));
    }

    @GetMapping("/reservation/confirmation/{confirmationNumber}")
    public ResponseEntity<Reservation> findReservationByConfirmationNumber(@PathVariable String confirmationNumber) {
        return ResponseEntity.ok(reservationService.getReservationByConfirmationNumber(confirmationNumber));
    }

    @PostMapping("/reservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDTO reservation) {
        Reservation newReservation = reservationService.createNewReservation(createReservationFromDTO(reservation));
        return ResponseEntity.ok(newReservation);
    }

    Reservation createReservationFromDTO(ReservationRequestDTO reservationRequestDTO) {
        Reservation newReservation = new Reservation();
        User user = userService.getUserByUsername(reservationRequestDTO.getUsername());

        newReservation.setTotalPrice(reservationRequestDTO.getTotalPrice());
        newReservation.setUser(user);
        newReservation.setCreatedAt(LocalDateTime.now());
        newReservation.setConfirmationNumber(ConfirmationNumberGenerator.generateConfirmationNumber(10));
        newReservation.setReservationStatus(ReservationStatus.CONFIRMED);

        return newReservation;
    }
}
