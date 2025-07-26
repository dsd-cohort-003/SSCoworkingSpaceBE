package com.teamsamuelsagar.coworkingspace.maintenance.service;

import com.teamsamuelsagar.coworkingspace.maintenance.entity.MaintenanceTicket;
import com.teamsamuelsagar.coworkingspace.maintenance.repository.MaintenanceTicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenanceTicketService {

    private final MaintenanceTicketRepository maintenanceTicketRepository;

    public MaintenanceTicketService(MaintenanceTicketRepository maintenanceTicketRepository) {
        this.maintenanceTicketRepository = maintenanceTicketRepository;
    }

    public List<MaintenanceTicket> getAllTickets() {
        return maintenanceTicketRepository.findAll();
    }

    public Optional<MaintenanceTicket> getTicketById(Long id) {
        return maintenanceTicketRepository.findById(id);
    }
}
