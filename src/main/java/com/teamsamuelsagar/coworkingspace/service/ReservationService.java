package com.teamsamuelsagar.coworkingspace.service;

import com.teamsamuelsagar.coworkingspace.dto.DeskReservationDTO;
import com.teamsamuelsagar.coworkingspace.dto.ReservationDTO;
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

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final UserService userService;
    private final DeskService deskService;
    private final ResourceService resourceService;
    private final ReservationRepository reservationRepository;
    private final DeskReservationService deskReservationService;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     * Retrieves a list of all public reservations, i.e., reservations that are not private
     * and have a start date that is today or later.
     *
     * @return a list of public reservations
     */
    public List<Reservation> getAllPublicReservations() {
        List<DeskReservation> currentDeskReservations = deskReservationService.findCurrentReservations();
        List<Reservation> reservations = currentDeskReservations.stream()
                .map(DeskReservation::getReservation)
                .filter(reservation -> !reservation.getIsPrivate())
                .collect(Collectors.toList());
        return reservations;
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
        newReservation.setIsPrivate(reservationRequestDTO.getIsPrivate());
        newReservation.setDescription(reservationRequestDTO.getDescription());

        return createNewReservation(newReservation);
    }
    
    public List<Reservation> getReservationsByUUID(UUID authUserId) {
        User foundUser = userService.getUserByAuthUserId(authUserId);

        return getReservationsByUserId(foundUser.getId());
    }

    public ReservationDTO createReservationDTOFromReservation(Reservation reservation) {
        ReservationDTO reservationDTO = new ReservationDTO();
        DeskReservation deskReservation = deskReservationService.findByReservationId(reservation.getId());

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
