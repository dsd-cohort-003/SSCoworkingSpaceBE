package com.teamsamuelsagar.coworkingspace.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceReservationDTO {
    private Long id;
    private Integer quantity;
    private LocalDate startDate;
    private LocalDate endDate;
}
