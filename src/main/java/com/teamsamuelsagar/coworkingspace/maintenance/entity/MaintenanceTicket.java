package com.teamsamuelsagar.coworkingspace.maintenance.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "maintainence_tickets")
public class MaintenanceTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String issueTitle;


    @Column(name = "time")
    private LocalDateTime issueDate;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "progress")
    private String ticketProgress;

    private String category;

    private String location;

    private String description;

    private String assignees;

    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String issueTitle) {
        this.issueTitle = issueTitle;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTicketProgress() {
        return ticketProgress;
    }

    public void setTicketProgress(String ticketProgress) {
        this.ticketProgress = ticketProgress;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignees() {
        return assignees;
    }

    public void setAssignees(String assignees) {
        this.assignees = assignees;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
