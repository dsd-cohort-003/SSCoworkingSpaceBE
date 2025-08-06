package com.teamsamuelsagar.coworkingspace.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;
import com.teamsamuelsagar.coworkingspace.repository.ResourceReservationRepository;

@Service
public class ResourceReservationService {

    @Autowired
    private ResourceReservationRepository resourceReservationRepository;

    /**
     * Retrieves a list of active reservations for the given resource id and date range.
     * <p>
     * A reservation is considered active if it is not complete and the date range overlaps
     * with the reservation's start and end dates.
     * </p>
     * @param resourceId the id of the resource to search by
     * @param startDate the start date of the range to search
     * @param endDate the end date of the range to search
     * @return a list of active reservations
     */
    public List<ResourceReservation> getReservationByResourceId(long resourceId, LocalDate startDate, LocalDate endDate) {
        return resourceReservationRepository.findActiveReservations(resourceId, startDate, endDate, List.of(ReservationStatus.PENDING, ReservationStatus.APPROVED));
    } // The ReservationStatus enums can easily be swapped out

}
