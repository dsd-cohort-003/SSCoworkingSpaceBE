package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceVideo extends ResourceAbstract {

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
