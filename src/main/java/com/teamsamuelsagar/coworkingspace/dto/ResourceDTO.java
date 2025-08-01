package com.teamsamuelsagar.coworkingspace.dto;

import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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
