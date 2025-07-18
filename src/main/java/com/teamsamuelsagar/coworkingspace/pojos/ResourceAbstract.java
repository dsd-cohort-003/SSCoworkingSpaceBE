package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

public abstract class ResourceAbstract {

    @Getter
    @Setter
    Protected long id;
    @Getter
    @Setter
    Protected String TYPE; // Should this be an enum? I'll set up the enum class to be implemented later if we want
    @Getter
    @Setter
    Protected int available;
    @Getter
    @Setter
    Protected double price;

}
