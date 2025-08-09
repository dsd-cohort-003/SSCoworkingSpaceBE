package com.teamsamuelsagar.coworkingspace.controller;

import com.teamsamuelsagar.coworkingspace.dto.MaintenanceTicketDTO;
import com.teamsamuelsagar.coworkingspace.model.MaintenanceTicket;
import com.teamsamuelsagar.coworkingspace.service.MaintenanceTicketService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/maintenance")
@RequiredArgsConstructor
public class MaintenanceTicketController {

    @Autowired
    private final MaintenanceTicketService ticketService;

    @GetMapping
    public List<MaintenanceTicket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaintenanceTicket> getTicketById(@PathVariable Long id) {
        return ticketService.getTicketById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<MaintenanceTicket> getTicketsByUser(@PathVariable Long userId) {
        return ticketService.getTicketsByUser(userId);
    }

    @GetMapping("/user/{userId}/unresolved")
    public List<MaintenanceTicket> getUnresolvedTicketsByUser(@PathVariable Long userId) {
        return ticketService.getUnresolvedTicketsByUser(userId);
    }

    @PostMapping
    public MaintenanceTicket createTicket(@RequestBody MaintenanceTicketDTO ticketDto) {
        return ticketService.createTicket(ticketDto, ticketDto.getUserId());
    }

    // For both user and admin updates — up to role-based filtering
    // TODO the isAdmin param is temporary until we have JWT role verification
    @PutMapping("/{id}")
    public ResponseEntity<MaintenanceTicket> updateTicket(@PathVariable Long id, @RequestBody MaintenanceTicketDTO ticketDto) {
        return ticketService.updateTicket(id, ticketDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // TODO verify role with JWT
    // @PutMapping("/admin/{id}")
    // public ResponseEntity<MaintenanceTicket> updateTicketAdmin(@PathVariable Long id, @RequestBody MaintenanceTicket ticket) {
    //     return ticketService.updateTicketAdmin(id, ticket)
    //             .map(ResponseEntity::ok)
    //             .orElse(ResponseEntity.notFound().build());
    // }


    // TODO change to confirm deletion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        if (ticketService.getTicketById(id).isPresent()) {
            ticketService.deleteTicket(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
