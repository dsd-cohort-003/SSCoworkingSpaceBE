package com.teamsamuelsagar.coworkingspace.dto;

import com.teamsamuelsagar.coworkingspace.enums.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.enums.ResourceType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDTO {

    private long id;
    private String name;
    private String description;
    private String imageUrl;
    private ResourceType type;
    private ResourceCategory category;
    private boolean reserved;

}
