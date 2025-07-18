package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceVideo extends ResourceAbstract {

    @Getter
    @Setter
    private String fieldOfView;

    @Getter
    @Setter
    private boolean isPortable;

    @Getter
    @Setter
    private boolean hasMicrophone;

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

    public ResourceVideo(long id, int available, double price, String name, String description, String fov, boolean portable, boolean hasMicrophone) {
        this.TYPE = "Video"; // ResourceType.Video;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
        this.fieldOfView = fov;
        this.isPortable = portable;
        this.hasMicrophone = hasMicrophone;
    }

    @Override
    public String getSummary() {
        return "Resource{\n" +
                "id = " + id +
                ", TYPE = '" + TYPE + '\'' +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", available = " + available +
                ", price = $" + price +
                ", fieldOfView = '" + fieldOfView + '\'' +
                ", isPortable = " + isPortable +
                ", hasMicrophone = " + hasMicrophone +
                "\n}";
    }

}
