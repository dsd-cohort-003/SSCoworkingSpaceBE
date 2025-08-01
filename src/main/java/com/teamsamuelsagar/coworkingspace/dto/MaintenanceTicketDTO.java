package com.teamsamuelsagar.coworkingspace.dto;

import com.teamsamuelsagar.coworkingspace.model.MaintenanceTicket;
import com.teamsamuelsagar.coworkingspace.model.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Doesn't include id or user, just for api requests
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceTicketDTO {
    private Long userId;
    private String title;
    private String category;
    private String location;
    private String description;
    private String image;
    private String status;  // Set to "open" by default, such as on initial submission
    private String assignees;   // null/empty on initial submission; set by admin

    public MaintenanceTicket toEntity(User user) {
        MaintenanceTicket ticket = new MaintenanceTicket();
        // ticket.setId(this.id); // Usually null on create
        ticket.setTitle(this.title);
        ticket.setCategory(this.category);
        ticket.setLocation(this.location);
        ticket.setDescription(this.description);
        ticket.setStatus(this.status);
        ticket.setUser(user); // passed explicitly to prevent leaking domain logic into DTO
        return ticket;
    }
}
