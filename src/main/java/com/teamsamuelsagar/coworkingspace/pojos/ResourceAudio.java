package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceAudio extends ResourceAbstract {

    @Getter
    @Setter
    private boolean isWireless;

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

    public ResourceAudio(long id, int available, double price, String name, String description, boolean wireless) {
        this.TYPE = "Audio"; // ResourceType.Audio;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
        this.isWireless = wireless;
    }

    /**
     * Returns a summary of the resource, including audio-specific attributes.
     * <p>
     * The summary will be in the format of a JSON object, with the following fields:
     * <ul>
     *     <li>id: the unique identifier of the resource</li>
     *     <li>TYPE: the type of the resource, e.g. "Audio"</li>
     *     <li>name: the name of the resource</li>
     *     <li>description: a brief description of the resource</li>
     *     <li>available: the number of resources available</li>
     *     <li>price: the price of the resource in dollars</li>
     *     <li>wireless: whether the resource is wireless</li>
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
                ", wireless = " + isWireless +
                "\n}";
    }

}
