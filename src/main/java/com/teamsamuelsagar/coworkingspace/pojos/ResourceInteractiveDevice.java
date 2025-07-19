package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceInteractiveDevice extends ResourceAbstract {

    @Getter
    @Setter
    private String screenSize;

    @Getter
    @Setter
    private boolean isPortable;

    @Getter
    @Setter
    private String platform; // e.g., "Windows", "Android", "Oculus"

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

    public ResourceInteractiveDevice(long id, int available, double price, String name, String description, String screenSize, boolean portable, String platform) {
        this.TYPE = "InteractiveDevice"; // ResourceType.InteractiveDevice;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
        this.screenSize = screenSize;
        this.isPortable = portable;
        this.platform = platform;
    }

    /**
     * Returns a summary of the interactive device resource, including interactive device-specific attributes.
     * <p>
     * The summary will be in the format of a JSON object, with the following fields:
     * <ul>
     *     <li>id: the unique identifier of the resource</li>
     *     <li>TYPE: the type of the resource, e.g. "InteractiveDevice"</li>
     *     <li>name: the name of the resource</li>
     *     <li>description: a brief description of the resource</li>
     *     <li>available: the number of resources available</li>
     *     <li>price: the price of the resource in dollars</li>
     *     <li>screenSize: the size of the device screen</li>
     *     <li>isPortable: indicates whether the device is portable</li>
     *     <li>platform: the platform of the device, e.g. "Windows", "Android", "Oculus"</li>
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
                ", isPortable = " + isPortable +
                ", platform = '" + platform + '\'' +
                "\n}";
    }

}
