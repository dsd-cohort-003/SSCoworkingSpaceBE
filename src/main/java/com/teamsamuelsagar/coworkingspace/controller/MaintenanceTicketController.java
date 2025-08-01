package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.model.MaintenanceTicket;
import com.teamsamuelsagar.coworkingspace.service.MaintenanceTicketService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maintenance")
public class MaintenanceTicketController {

    private final MaintenanceTicketService maintenanceTicketService;

    public MaintenanceTicketController(MaintenanceTicketService maintenanceTicketService) {
        this.maintenanceTicketService = maintenanceTicketService;
    }

    @GetMapping
    public ResponseEntity<List<MaintenanceTicket>> getAllTickets() {

        List<MaintenanceTicket> maintenanceTickets = maintenanceTicketService.getAllTickets();

        System.out.println(maintenanceTickets);

        return ResponseEntity.ok(maintenanceTickets);
    }

    @GetMapping("/maintenance/{ticket_id}")
    public ResponseEntity<MaintenanceTicket> getTicketById(@PathVariable String ticket_id) {
        MaintenanceTicket ticket = maintenanceTicketService.getTicketById(Long.parseLong(ticket_id));
        return ResponseEntity.ok(ticket);
    }
}
