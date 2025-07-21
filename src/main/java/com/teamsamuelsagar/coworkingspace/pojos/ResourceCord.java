package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

public class ResourceCord extends ResourceAbstract {

    @Getter
    @Setter
    private String length;

    @Getter
    @Setter
    private String connectorType;

    @Getter
    @Setter
    private boolean surgeProtected;
    
}
