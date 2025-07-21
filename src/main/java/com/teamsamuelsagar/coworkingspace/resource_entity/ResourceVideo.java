package com.teamsamuelsagar.coworkingspace.resource_entity;

import lombok.Getter;
import lombok.Setter;

public class ResourceVideo extends ResourceAbstract {

    @Getter
    @Setter
    private String fieldOfView;

    @Getter
    @Setter
    private boolean isPortable;

    @Getter
    @Setter
    private boolean hasMicrophone;

}
