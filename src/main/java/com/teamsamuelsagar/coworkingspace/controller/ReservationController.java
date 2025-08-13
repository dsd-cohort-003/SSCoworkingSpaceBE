package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.dto.ReservationRequestDTO;

import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.service.ReservationService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> findAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();

        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/public")
    public ResponseEntity<List<Reservation>> findPublicReservations() {
        return ResponseEntity.ok(reservationService.getAllPublicReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Reservation>> findReservationById(@PathVariable String id) {
        return ResponseEntity.ok(reservationService.getReservationById(Long.parseLong(id)));
    }

    @GetMapping("/confirmation/{confirmationNumber}")
    public ResponseEntity<Reservation> findReservationByConfirmationNumber(@PathVariable String confirmationNumber) {
        return ResponseEntity.ok(reservationService.getReservationByConfirmationNumber(confirmationNumber));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> findReservationByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(reservationService.getReservationsByUserId(Long.parseLong(userId)));
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDTO reservation) {
        Reservation newReservation = reservationService.createReservationFromDTO(reservation);

        return ResponseEntity.ok(newReservation);
    }


}
