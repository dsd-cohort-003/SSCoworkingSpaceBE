package com.teamsamuelsagar.coworkingspace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    // private String username;
    // private Long userId;
    private UUID authUserId;

    private BigDecimal totalPrice;

    private DeskReservationDTO deskReservation;
    private List<ResourceReservationDTO> resourceReservations;

    private Boolean isPrivate;

    private String description;
}
