package com.teamsamuelsagar.coworkingspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.MaintenanceTicket;

@Repository
public interface MaintenanceTicketRepository extends JpaRepository<MaintenanceTicket, Long> {
    List<MaintenanceTicket> findByUserId(Long userId);
    List<MaintenanceTicket> findByUserIdAndStatusNot(Long userId, String status);
}
