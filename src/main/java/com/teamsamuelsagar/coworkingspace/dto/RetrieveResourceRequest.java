package com.teamsamuelsagar.coworkingspace.dto;

import java.time.LocalDate;

import lombok.Data;

/**
 * RetrieveResourceRequest JSON layout:
 * {
 *     "officeId": 1,
 *     "startDate": "2023-01-01",
 *     "endDate": "2023-01-31"
 * }
 */
@Data
public class RetrieveResourceRequest {

    private long officeId;
    private LocalDate startDate;
    private LocalDate endDate;

}
