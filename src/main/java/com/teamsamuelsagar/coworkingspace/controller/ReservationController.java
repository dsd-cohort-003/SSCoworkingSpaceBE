package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.dto.ReservationDTO;
import com.teamsamuelsagar.coworkingspace.dto.ReservationRequestDTO;

import com.teamsamuelsagar.coworkingspace.model.Desk;
import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import com.teamsamuelsagar.coworkingspace.repository.DeskRepository;
import com.teamsamuelsagar.coworkingspace.repository.DeskReservationRepository;
import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.repository.ResourceRepository;
import com.teamsamuelsagar.coworkingspace.repository.ResourceReservationRepository;
import com.teamsamuelsagar.coworkingspace.model.User;
import com.teamsamuelsagar.coworkingspace.service.UserService;
import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;
import com.teamsamuelsagar.coworkingspace.service.ReservationService;
import com.teamsamuelsagar.coworkingspace.util.ConfirmationNumberGenerator;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    private final UserService userService;

    private final DeskRepository deskRepository;

    private final DeskReservationRepository deskReservationRepository;

    private final ResourceRepository resourceRepository;
    
    private final ResourceReservationRepository resourceReservationRepository;

    @GetMapping
    public ResponseEntity<List<ReservationDTO>> findAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations()
                .stream().map(this::createReservationDTOFromReservation).toList());
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
        Reservation newReservation = reservationService.createNewReservation(createReservationFromDTO(reservation));

        Desk newDesk = deskRepository.findById(reservation.getDeskId()).get();
        DeskReservation deskReservation = new DeskReservation();
        deskReservation.setDesk(newDesk);
        deskReservation.setReservation(newReservation);
        deskReservation.setStartDate(LocalDate.parse(reservation.getStartDate()));
        deskReservation.setEndDate(LocalDate.parse(reservation.getEndDate()));
        deskReservation.setStatus(String.valueOf(ReservationStatus.APPROVED));
        deskReservationRepository.save(deskReservation);


        reservation.getResourceIds().forEach(id -> {
            ResourceReservation resourceReservation = new ResourceReservation();
            Resource resource = resourceRepository.getById(id);
            resourceReservation.setResource(resource);
            resourceReservation.setReservation(newReservation);
            resourceReservation.setStartDate(LocalDate.parse(reservation.getStartDate()));
            resourceReservation.setEndDate(LocalDate.parse(reservation.getEndDate()));
            resourceReservation.setStatus(ReservationStatus.APPROVED);

            resourceReservationRepository.save(resourceReservation);
        });

        return ResponseEntity.ok(newReservation);
    }

    Reservation createReservationFromDTO(ReservationRequestDTO reservationRequestDTO) {
        Reservation newReservation = new Reservation();
        User user = userService.getUserByUsername(reservationRequestDTO.getUsername());

        newReservation.setTotalPrice(reservationRequestDTO.getTotalPrice());
        newReservation.setUser(user);
        newReservation.setCreatedAt(LocalDateTime.now());
        newReservation.setConfirmationNumber(ConfirmationNumberGenerator.generateConfirmationNumber(10));
        newReservation.setReservationStatus(ReservationStatus.APPROVED);

        return newReservation;
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
