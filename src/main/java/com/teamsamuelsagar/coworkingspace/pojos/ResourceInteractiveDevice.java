package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceInteractiveDevice extends ResourceAbstract {

    public ResourceInteractiveDevice() {
        this.TYPE = "InteractiveDevice"; // ResourceType.InteractiveDevice;
    }

    public ResourceInteractiveDevice(long id, int available, double price, String name, String description) {
        this.TYPE = "InteractiveDevice"; // ResourceType.InteractiveDevice;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
    }

}
