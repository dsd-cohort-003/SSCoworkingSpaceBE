package com.teamsamuelsagar.coworkingspace.maintenance.repository;

import com.teamsamuelsagar.coworkingspace.maintenance.entity.MaintenanceTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceTicketRepository extends JpaRepository<MaintenanceTicket, Long> {
}
