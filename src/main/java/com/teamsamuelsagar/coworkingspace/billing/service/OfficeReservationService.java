package com.teamsamuelsagar.coworkingspace.billing.service;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.billing.entity.OfficeReservation;
import com.teamsamuelsagar.coworkingspace.billing.repository.OfficeReservationRepository;

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
