package com.teamsamuelsagar.coworkingspace.dto;

import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {

    private long officeId;
    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private float price;
    private ResourceType type;
    private ResourceCategory category;
    private boolean reserved;

}
