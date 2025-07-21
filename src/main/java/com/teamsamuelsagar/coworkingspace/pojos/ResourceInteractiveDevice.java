package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

public class ResourceInteractiveDevice extends ResourceAbstract {

    @Getter
    @Setter
    private String screenSize;

    @Getter
    @Setter
    private boolean isPortable;

    @Getter
    @Setter
    private String platform; // e.g., "Windows", "Android", "Oculus"
    
}
