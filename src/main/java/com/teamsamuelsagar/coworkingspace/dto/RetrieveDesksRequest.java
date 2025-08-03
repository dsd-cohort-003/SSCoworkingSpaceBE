package com.teamsamuelsagar.coworkingspace.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RetrieveDesksRequest {
    private Date startDate;
    private Date endDate;
}
