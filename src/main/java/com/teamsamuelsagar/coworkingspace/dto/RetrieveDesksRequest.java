package com.teamsamuelsagar.coworkingspace.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RetrieveDesksRequest {
    private LocalDate startDate;
    private LocalDate endDate;
}
