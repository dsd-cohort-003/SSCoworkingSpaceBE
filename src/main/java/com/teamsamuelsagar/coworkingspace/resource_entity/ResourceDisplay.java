package com.teamsamuelsagar.coworkingspace.resource_entity;

import lombok.Getter;
import lombok.Setter;

public class ResourceDisplay extends ResourceAbstract {

    @Getter
    @Setter
    private String screenSize;

    @Getter
    @Setter
    private String resolution;

    @Getter
    @Setter
    private boolean isPortable;

}
