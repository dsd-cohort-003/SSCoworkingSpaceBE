package com.teamsamuelsagar.coworkingspace.maintenance.controller;

import com.teamsamuelsagar.coworkingspace.maintenance.entity.MaintenanceTicket;
import com.teamsamuelsagar.coworkingspace.maintenance.service.MaintenanceTicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

@Controller
public class MaintenanceTicketController {

    private final MaintenanceTicketService maintenanceTicketService;

    public MaintenanceTicketController(MaintenanceTicketService maintenanceTicketService) {
        this.maintenanceTicketService = maintenanceTicketService;
    }

    @GetMapping("/maintenance")
    public ResponseEntity<List<MaintenanceTicket>> getAllTickets() {

        List<MaintenanceTicket> maintenanceTickets = maintenanceTicketService.getAllTickets();

        System.out.println(maintenanceTickets);

        return ResponseEntity.ok(maintenanceTickets);
    }

    @GetMapping("/maintenance/{ticket_id}")
    public ResponseEntity<Optional<MaintenanceTicket>> getTicketById(@PathVariable String ticket_id) {
        Optional<MaintenanceTicket> ticket = maintenanceTicketService.getTicketById(Long.parseLong(ticket_id));

        if(ticket.isPresent()) {
            return ResponseEntity.ok(ticket);
        }

        return ResponseEntity.badRequest().build();
    }
}
