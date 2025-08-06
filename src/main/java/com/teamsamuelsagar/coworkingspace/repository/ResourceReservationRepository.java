package com.teamsamuelsagar.coworkingspace.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;

@Repository
public interface ResourceReservationRepository extends JpaRepository<ResourceReservation, Long> {

    Optional<ResourceReservation> findById(Long id);

    ResourceReservation findByReservationId(Long id);

    List<ResourceReservation> findByResourceId(Long id);

    @Query("""
            SELECT r FROM ResourceReservation r
            WHERE r.resource.id = :resourceId
            AND r.status in (:activeStatus)
            AND r.startDate < :endDate
            AND r.endDate > :startDate
            """)
    List<ResourceReservation> findActiveReservations(
        @Param("resourceId") Long resourceId, 
        @Param("startDate") LocalDate startDate, 
        @Param("endDate") LocalDate endDate, 
        @Param("activeStatus") List<ReservationStatus> activeStatus
        );

}
