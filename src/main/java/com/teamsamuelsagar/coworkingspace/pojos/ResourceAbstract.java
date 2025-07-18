package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

import lombok.Getter;
import lombok.Setter;

public abstract class ResourceAbstract {

    @Getter
    @Setter
    protected long id;

    @Getter
    @Setter
    protected String TYPE; // ResourceType TYPE; --- Should this be an enum, ResourceType?

    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected String description;

    @Getter
    @Setter
    protected int available;

    @Getter
    @Setter
    protected double price;

}
