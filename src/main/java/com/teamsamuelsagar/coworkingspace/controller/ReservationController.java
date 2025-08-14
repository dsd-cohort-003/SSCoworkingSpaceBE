package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.dto.ReservationDTO;
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
import java.util.UUID;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAllReservations() {
        return ResponseEntity.ok(
            reservationService.getAllReservations()
                .stream()
                .map(reservationService::createReservationDTOFromReservation)
                .toList()
        );
    }
    
    @GetMapping("/public")
    public ResponseEntity<List<ReservationDTO>> findPublicReservations() {
        return ResponseEntity.ok(
            reservationService.getAllPublicReservations().stream()
                .map(reservationService::createReservationDTOFromReservation)
                .toList()
        );
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> findReservationById(
        @PathVariable String id
    ) {
        Optional<Reservation> foundReservation =
            reservationService.getReservationById(Long.parseLong(id));
    
        if (foundReservation.isPresent()) {
            return ResponseEntity.ok(
                reservationService.createReservationDTOFromReservation(
                    foundReservation.get()
                )
            );
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/confirmation/{confirmationNumber}")
    public ResponseEntity<ReservationDTO> findReservationByConfirmationNumber(
        @PathVariable String confirmationNumber
    ) {
        return ResponseEntity.ok(
            reservationService.createReservationDTOFromReservation(
                reservationService.getReservationByConfirmationNumber(
                    confirmationNumber
                )
            )
        );
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationDTO>> findReservationByUserId(
        @PathVariable String userId
    ) {
        return ResponseEntity.ok(
            reservationService.getReservationsByUserId(
                Long.parseLong(userId)
            ).stream()
             .map(reservationService::createReservationDTOFromReservation)
             .toList()
        );
    }
    
    @GetMapping("/user/auth/{authUserId}")
    public ResponseEntity<List<ReservationDTO>> findReservationByUserName(
        @PathVariable UUID authUserId
    ) {
        return ResponseEntity.ok(
            reservationService.getReservationsByUUID(authUserId)
                .stream()
                .map(reservationService::createReservationDTOFromReservation)
                .toList()
        );
    }
    
    @PostMapping
    public ResponseEntity<Reservation> createReservation(
        @RequestBody ReservationRequestDTO reservation
    ) {
        Reservation newReservation =
            reservationService.createReservationFromDTO(reservation);
    
        return ResponseEntity.ok(newReservation);
    }
    
}
