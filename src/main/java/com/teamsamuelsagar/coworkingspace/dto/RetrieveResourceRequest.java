package com.teamsamuelsagar.coworkingspace.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class RetrieveResourceRequest {

    private long officeId;
    private LocalDate startDate;
    private LocalDate endDate;

}
