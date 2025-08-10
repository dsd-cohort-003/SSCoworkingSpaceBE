package com.teamsamuelsagar.coworkingspace.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    private String username;

    private BigDecimal totalPrice;

    private Long deskId;

    private String startDate;

    private String endDate;

    private List<Long> resourceIds;

    private Boolean isPrivate;

    private String description;
}
