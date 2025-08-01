package com.teamsamuelsagar.coworkingspace.model;



import com.teamsamuelsagar.coworkingspace.model.enumtype.ReservationStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String confirmationNumber;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;

   /* @OneToOne(
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private DeskReservation deskReservation;

    @OneToOne(
            mappedBy = "reservation",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private ResourceReservation resourceReservation;*/

    public Reservation() {
    }

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

    /*public DeskReservation getDeskReservation() {
        return deskReservation;
    }

    public void setDeskReservation(DeskReservation deskReservation) {
        this.deskReservation = deskReservation;
    }

    public ResourceReservation getResourceReservation() {
        return resourceReservation;
    }

    public void setResourceReservation(ResourceReservation resourceReservation) {
        this.resourceReservation = resourceReservation;
    }*/
}
