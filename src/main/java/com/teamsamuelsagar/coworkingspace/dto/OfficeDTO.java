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

    private String state;

    private String city;

    private String description;

    private String streetAddress;

    private String zipcode;
}
