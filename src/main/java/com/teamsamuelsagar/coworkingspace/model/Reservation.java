package com.teamsamuelsagar.coworkingspace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<ResourceReservation> resourceReservations = new ArrayList<>();

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

}
