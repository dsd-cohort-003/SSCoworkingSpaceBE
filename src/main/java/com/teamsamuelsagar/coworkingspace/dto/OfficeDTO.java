package com.teamsamuelsagar.coworkingspace.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OfficeDTO {
    private String name;
    private Double price;
    private Double size;
}
