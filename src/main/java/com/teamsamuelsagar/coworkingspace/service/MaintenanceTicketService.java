package com.teamsamuelsagar.coworkingspace.service;

import com.teamsamuelsagar.coworkingspace.dto.MaintenanceTicketDTO;
import com.teamsamuelsagar.coworkingspace.model.MaintenanceTicket;
import com.teamsamuelsagar.coworkingspace.model.User;
import com.teamsamuelsagar.coworkingspace.repository.MaintenanceTicketRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaintenanceTicketService {

    private final MaintenanceTicketRepository ticketRepository;
    private final UserService userService;

    public List<MaintenanceTicket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Optional<MaintenanceTicket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    public List<MaintenanceTicket> getTicketsByUser(Long userId) {
        return ticketRepository.findByUserId(userId);
    }

    public List<MaintenanceTicket> getUnresolvedTicketsByUser(Long userId) {
        return ticketRepository.findByUserIdAndStatusNot(userId, "resolved");
    }

    public MaintenanceTicket createTicket(MaintenanceTicket ticket) {
        return ticketRepository.save(ticket);
    }

    public MaintenanceTicket createTicket(MaintenanceTicketDTO dto, Long userId) {
        User user = userService.getUserById(userId);
        
        if (dto.getStatus() == null || dto.getStatus().isBlank()) {
            dto.setStatus("open");
        }

        // Note: id is null, but will be auto-assigned on being saved to db
        MaintenanceTicket ticket = dto.toEntity(user);
        return ticketRepository.save(ticket);
    }

    // Can revise what a user can update
    public Optional<MaintenanceTicket> updateTicket(Long id, MaintenanceTicketDTO dto) {
        return ticketRepository.findById(id).map(ticket -> {
            // Limited user-updatable fields
            if (dto.getTitle() != null) ticket.setTitle(dto.getTitle());
            if (dto.getCategory() != null) ticket.setCategory(dto.getCategory());
            if (dto.getLocation() != null) ticket.setLocation(dto.getLocation());
            if (dto.getDescription() != null) ticket.setDescription(dto.getDescription());
            if (dto.getStatus() != null) ticket.setStatus(dto.getStatus());
            if (dto.getAssignees() != null) ticket.setAssignees(dto.getAssignees());
            if (dto.getImage() != null) ticket.setImage(dto.getImage());
            return ticketRepository.save(ticket);
        });
    }

    public Optional<MaintenanceTicket> updateTicketAdmin(Long id, MaintenanceTicket ticket) {
        return ticketRepository.findById(id).map(existing -> {
            // Admin-updatable fields
            existing.setTitle(ticket.getTitle());
            existing.setCategory(ticket.getCategory());
            existing.setLocation(ticket.getLocation());
            existing.setDescription(ticket.getDescription());
            existing.setImage(ticket.getImage());
            existing.setStatus(ticket.getStatus());
            existing.setAssignees(ticket.getAssignees());
            return ticketRepository.save(existing);
        });
    }

    // TODO change to confirm deletion
    public void deleteTicket(Long id) {
        ticketRepository.deleteById(id);
    }
}
