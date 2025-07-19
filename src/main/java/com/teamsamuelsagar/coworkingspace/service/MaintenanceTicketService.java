package com.teamsamuelsagar.coworkingspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.repository.MaintenanceTicketRepository;

@Service
public class MaintenanceTicketService {
    @Autowired
    private MaintenanceTicketRepository maintenanceTicketRepository;

    public String getAllTickets() {
        // Logic to retrieve all maintenance tickets
        return "List of all maintenance tickets";
    }
}
