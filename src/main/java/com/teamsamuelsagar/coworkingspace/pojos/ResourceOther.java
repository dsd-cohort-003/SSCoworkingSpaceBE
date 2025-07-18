package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceOther extends ResourceAbstract {

    public ResourceOther() {
        this.TYPE = "Other"; // ResourceType.Other;
    }

    public ResourceOther(long id, int available, double price, String name, String description) {
        this.TYPE = "Other"; // ResourceType.Other;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
    }

}
