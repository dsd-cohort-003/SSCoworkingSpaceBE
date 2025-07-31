package com.teamsamuelsagar.coworkingspace.service;

import com.teamsamuelsagar.coworkingspace.model.MaintenanceTicket;
import com.teamsamuelsagar.coworkingspace.repository.MaintenanceTicketRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaintenanceTicketService {

    private final MaintenanceTicketRepository maintenanceTicketRepository;

    public MaintenanceTicketService(MaintenanceTicketRepository maintenanceTicketRepository) {
        this.maintenanceTicketRepository = maintenanceTicketRepository;
    }

    public List<MaintenanceTicket> getAllTickets() {
        return maintenanceTicketRepository.findAll();
    }

    public MaintenanceTicket getTicketById(Long id) {
        return maintenanceTicketRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Ticket ID not found"));
    }
}
