package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.dto.ReservationRequestDTO;

import com.teamsamuelsagar.coworkingspace.model.Desk;
import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import com.teamsamuelsagar.coworkingspace.repository.DeskRepository;
import com.teamsamuelsagar.coworkingspace.repository.DeskReservationRepository;
import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.repository.ResourceRepository;
import com.teamsamuelsagar.coworkingspace.repository.ResourceReservationRepository;
import com.teamsamuelsagar.coworkingspace.service.ResourceService;
import com.teamsamuelsagar.coworkingspace.model.User;
import com.teamsamuelsagar.coworkingspace.service.UserService;
import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;
import com.teamsamuelsagar.coworkingspace.service.ReservationService;
import com.teamsamuelsagar.coworkingspace.util.ConfirmationNumberGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;
    
    @Autowired
    private final UserService userService;

    @Autowired
    private final DeskRepository deskRepository;

    @Autowired
    private final DeskReservationRepository deskReservationRepository;

    @Autowired
    private final ResourceRepository resourceRepository;
    
    @Autowired
    private final ResourceReservationRepository resourceReservationRepository;

    public ReservationController(
            ReservationService reservationService,
            UserService userService,
            DeskRepository deskRepository,
            DeskReservationRepository deskReservationRepository,
            ResourceRepository resourceRepository,
            ResourceReservationRepository resourceReservationRepository) {
        this.reservationService = reservationService;
        this.userService = userService;
        this.deskRepository = deskRepository;
        this.deskReservationRepository = deskReservationRepository;
        this.resourceRepository = resourceRepository;
        this.resourceReservationRepository = resourceReservationRepository;
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

    @GetMapping("/reservation/user/{userId}")
    public ResponseEntity<List<Reservation>> findReservationByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(reservationService.getReservationsByUserId(Long.parseLong(userId)));
    }

    @PostMapping("/reservation")
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
            Optional<Resource> resource = resourceRepository.findById(id);
            resource.ifPresent(resourceReservation::setResource);
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
}
