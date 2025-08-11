package com.teamsamuelsagar.coworkingspace.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeskReservationDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
}
