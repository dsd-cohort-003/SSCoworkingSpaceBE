package com.teamsamuelsagar.coworkingspace.service;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.entity.OfficeReservation;
import com.teamsamuelsagar.coworkingspace.repository.OfficeReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfficeReservationService {
    private final OfficeReservationRepository reservationRepository;

    public OfficeReservation getReservationById(Long id) {
        return reservationRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
    }
}
