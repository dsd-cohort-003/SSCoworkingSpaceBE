package com.teamsamuelsagar.coworkingspace.service;

import com.teamsamuelsagar.coworkingspace.dto.DeskReservationDTO;
import com.teamsamuelsagar.coworkingspace.dto.ReservationRequestDTO;
import com.teamsamuelsagar.coworkingspace.dto.ResourceReservationDTO;
import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.model.User;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;
import com.teamsamuelsagar.coworkingspace.repository.ReservationRepository;
import com.teamsamuelsagar.coworkingspace.util.ConfirmationNumberGenerator;

import jakarta.persistence.EntityNotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final UserService userService;
    private final DeskService deskService;
    private final ResourceService resourceService;
    private final ReservationRepository reservationRepository;

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

    public Reservation createReservationFromDTO(ReservationRequestDTO reservationRequestDTO) {

        Reservation newReservation = new Reservation();
        User user = userService.getUserByAuthUserId(reservationRequestDTO.getAuthUserId());

        DeskReservationDTO deskReservationDTO = reservationRequestDTO.getDeskReservation();
        DeskReservation newDeskReservation = new DeskReservation();
        newDeskReservation.setDesk(deskService.getDesk(deskReservationDTO.getId()));
        newDeskReservation.setStartDate(deskReservationDTO.getStartDate());
        newDeskReservation.setEndDate(deskReservationDTO.getEndDate());
        newDeskReservation.setReservation(newReservation);
        newDeskReservation.setStatus(ReservationStatus.BOOKED.toString());
        newReservation.setDeskReservation(newDeskReservation);

        for (ResourceReservationDTO rrDto : reservationRequestDTO.getResourceReservations()) {
            Resource resource = resourceService.getResourceById(rrDto.getId());
            ResourceReservation resourceReservation = new ResourceReservation();
            resourceReservation.setResource(resource);
            resourceReservation.setQuantity(rrDto.getQuantity());
            resourceReservation.setReservation(newReservation);
            resourceReservation.setStartDate(rrDto.getStartDate());
            resourceReservation.setEndDate(rrDto.getEndDate());
            newReservation.getResourceReservations().add(resourceReservation);
        }

        newReservation.setTotalPrice(reservationRequestDTO.getTotalPrice());
        newReservation.setUser(user);
        newReservation.setCreatedAt(LocalDateTime.now());
        newReservation.setConfirmationNumber(ConfirmationNumberGenerator.generateConfirmationNumber(10));
        newReservation.setReservationStatus(ReservationStatus.APPROVED);

        return createNewReservation(newReservation);
    }
}
