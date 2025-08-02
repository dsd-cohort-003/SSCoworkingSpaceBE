package com.teamsamuelsagar.coworkingspace.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;
import com.teamsamuelsagar.coworkingspace.repository.ResourceReservationRepository;

public class ResourceReservationService {

    @Autowired
    private ResourceReservationRepository resourceReservationRepository;

    public List<ResourceReservation> getReservationByResourceId(long resourceId, LocalDate startDate, LocalDate endDate) {
        return resourceReservationRepository.findActiveReservations(resourceId, startDate, endDate, List.of(ReservationStatus.PENDING, ReservationStatus.APPROVED));
    }

}
