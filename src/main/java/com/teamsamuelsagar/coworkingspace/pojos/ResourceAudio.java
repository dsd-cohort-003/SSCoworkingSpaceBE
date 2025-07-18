package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

import lombok.Getter;
import lombok.Setter;

public class ResourceAudio extends ResourceAbstract {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

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
