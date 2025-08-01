package com.teamsamuelsagar.coworkingspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;

@Repository
public interface ResourceReservationRepository {

    ResourceReservation findById(Long id);

    ResourceReservation findByReservationId(Long id);

    List<ResourceReservation> findByResourceId(Long id);

    @Query("""
            SELECT r FROM resource_reservation r
            WHERE r.resource.id = :resourceId
            AND r.status in (:activeStatus)
            AND r.start_date < :endDate
            AND r.end_date > :startDate
            """)
    List<ResourceReservation> findActiveReservations(
        @Param("resourceId") Long resourceId, 
        @Param("startDate") String startDate, 
        @Param("endDate") String endDate, 
        @Param("activeStatus") List<ReservationStatus> activeStatus
        );

}
