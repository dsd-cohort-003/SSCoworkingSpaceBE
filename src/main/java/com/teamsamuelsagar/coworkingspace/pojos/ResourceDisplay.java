package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceDisplay extends ResourceAbstract {

    @Getter
    @Setter
    private String screenSize;

    @Getter
    @Setter
    private String resolution;

    @Getter
    @Setter
    private boolean isPortable;

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

    public ResourceDisplay(long id, int available, double price, String name, String description, String screenSize, String resolution, boolean portable) {
        this.TYPE = "Display"; // ResourceType.Display;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
        this.screenSize = screenSize;
        this.resolution = resolution;
        this.isPortable = portable;
    }

    /**
     * Returns a summary of the display resource, including display-specific attributes.
     * <p>
     * The summary will be in the format of a JSON object, with the following fields:
     * <ul>
     *     <li>id: the unique identifier of the resource</li>
     *     <li>TYPE: the type of the resource, e.g. "Display"</li>
     *     <li>name: the name of the resource</li>
     *     <li>description: a brief description of the resource</li>
     *     <li>available: the number of resources available</li>
     *     <li>price: the price of the resource in dollars</li>
     *     <li>screenSize: the size of the display screen</li>
     *     <li>resolution: the resolution of the display</li>
     *     <li>portable: indicates whether the display is portable</li>
     * </ul>
     * </p>
     */
    @Override
    public String getSummary() {
        return "Resource{\n" +
                "id = " + id +
                ", TYPE = '" + TYPE + '\'' +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", available = " + available +
                ", price = $" + price +
                ", screenSize = '" + screenSize + '\'' +
                ", resolution = '" + resolution + '\'' +
                ", portable = " + isPortable +
                "\n}";
    }

}
