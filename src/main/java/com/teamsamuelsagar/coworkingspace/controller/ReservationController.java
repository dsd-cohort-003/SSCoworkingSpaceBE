package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.dto.ReservationDTO;
import com.teamsamuelsagar.coworkingspace.dto.ReservationRequestDTO;
import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.repository.DeskReservationRepository;
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
    private final DeskReservationRepository deskReservationRepository;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations()
                .stream().map(this::createReservationDTOFromReservation).toList());
    }

    @GetMapping("/public")
    public ResponseEntity<List<Reservation>> findPublicReservations() {
        return ResponseEntity.ok(reservationService.getAllPublicReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> findReservationById(@PathVariable String id) {
        Optional<Reservation> foundReservation = reservationService.getReservationById(Long.parseLong(id));

        if(foundReservation.isPresent()) {
            return ResponseEntity.ok(createReservationDTOFromReservation(foundReservation.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/confirmation/{confirmationNumber}")
    public ResponseEntity<ReservationDTO> findReservationByConfirmationNumber(@PathVariable String confirmationNumber) {
        return ResponseEntity.ok(createReservationDTOFromReservation(
                reservationService.getReservationByConfirmationNumber(confirmationNumber)));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationDTO>> findReservationByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(reservationService.getReservationsByUserId(Long.parseLong(userId))
                .stream().map(this::createReservationDTOFromReservation).toList());
    }

    @GetMapping("/user/auth/{authUserId}")
    public ResponseEntity<List<ReservationDTO>> findReservationByUserName(@PathVariable UUID authUserId) {
        return ResponseEntity.ok(reservationService.getReservationsByUUID(authUserId)
                .stream().map(this::createReservationDTOFromReservation).toList());
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDTO reservation) {
        Reservation newReservation = reservationService.createReservationFromDTO(reservation);

        return ResponseEntity.ok(newReservation);
    }

    ReservationDTO createReservationDTOFromReservation(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        DeskReservation deskReservation = deskReservationRepository.findByReservationId(reservation.getId());

        reservationDTO.setId(reservation.getId());
        reservationDTO.setUser(reservation.getUser());
        reservationDTO.setDescription(reservation.getDescription());
        reservationDTO.setTotalPrice(reservation.getTotalPrice());
        reservationDTO.setConfirmationNumber(reservation.getConfirmationNumber());
        reservationDTO.setPrivate(reservation.getIsPrivate());
        reservationDTO.setReservationStatus(reservation.getReservationStatus());
        reservationDTO.setCreatedAt(reservation.getCreatedAt());

        if(deskReservation != null) {
            reservationDTO.setStartDate(deskReservation.getStartDate());
            reservationDTO.setEndDate(deskReservation.getEndDate());
        }

        return reservationDTO;
    }
}
