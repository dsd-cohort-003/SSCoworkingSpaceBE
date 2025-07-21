package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

public class ResourcePrinter extends ResourceAbstract {

    @Getter
    @Setter
    private String printType;

    @Getter
    @Setter
    private boolean printColor;
}
