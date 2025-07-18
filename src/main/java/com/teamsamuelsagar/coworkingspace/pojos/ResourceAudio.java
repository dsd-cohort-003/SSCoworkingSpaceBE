package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceAudio extends ResourceAbstract {

    public ResourceAudio() {
        this.TYPE = "Audio"; // ResourceType.Audio;
    }

    public ResourceAudio(long id, int available, double price, String name, String description) {
        this.TYPE = "Audio"; // ResourceType.Audio;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
    }

}
