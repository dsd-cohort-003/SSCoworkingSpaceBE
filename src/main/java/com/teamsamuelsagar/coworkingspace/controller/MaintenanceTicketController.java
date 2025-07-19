package com.teamsamuelsagar.coworkingspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.service.MaintenanceTicketService;

@RestController
@RequestMapping("/api/tickets")
public class MaintenanceTicketController {
    @Autowired
    private MaintenanceTicketService maintenanceTicketService;

    @GetMapping("/")
    public ResponseEntity<String> getAllTickets() {
        String ticketsList = maintenanceTicketService.getAllTickets();
        // Logic to retrieve all maintenance tickets
        return ResponseEntity.ok(ticketsList);
    }
}
