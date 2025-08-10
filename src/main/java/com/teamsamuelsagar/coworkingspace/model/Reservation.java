package com.teamsamuelsagar.coworkingspace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String confirmationNumber;

    private Boolean isPrivate;

    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private DeskReservation deskReservation;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<ResourceReservation> resourceReservation;

    public Reservation(Long id,
                   User user,
                   BigDecimal totalPrice,
                   LocalDateTime createdAt,
                   String confirmationNumber,
                   ReservationStatus reservationStatus) {
        this.id = id;
        this.user = user;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.confirmationNumber = confirmationNumber;
        this.reservationStatus = reservationStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(String confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}
