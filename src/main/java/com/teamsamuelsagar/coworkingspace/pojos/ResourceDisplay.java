package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceDisplay extends ResourceAbstract {

    public ResourceDisplay() {
        this.TYPE = "Display"; // ResourceType.Display;
    }

    public ResourceDisplay(long id, int available, double price, String name, String description) {
        this.TYPE = "Display"; // ResourceType.Display;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
    }

}
