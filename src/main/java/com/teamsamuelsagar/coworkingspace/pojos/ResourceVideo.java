package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

import lombok.Getter;
import lombok.Setter;

public class ResourceVideo extends ResourceAbstract {

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;

    public ResourceVideo() {
        this.TYPE = "Video"; // ResourceType.Video;
    }

    public ResourceVideo(long id, int available, double price, String name, String description) {
        this.TYPE = "Video"; // ResourceType.Video;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
    }

}
