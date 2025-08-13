package com.teamsamuelsagar.coworkingspace.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import com.teamsamuelsagar.coworkingspace.repository.DeskReservationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeskReservationService {

    private final DeskReservationRepository deskReservationRepository;

    public List<DeskReservation> findAll() {
        return deskReservationRepository.findAll();
    }

    public DeskReservation findByReservationId(Long reservationId) {
        return deskReservationRepository.findByReservationId(reservationId);
    }

    public List<DeskReservation> findCurrentReservations() {
        return deskReservationRepository.findCurrentReservations(LocalDate.now());
    }
}

