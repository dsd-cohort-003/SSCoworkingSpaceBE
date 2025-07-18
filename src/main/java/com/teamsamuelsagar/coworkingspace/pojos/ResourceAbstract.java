package com.teamsamuelsagar.coworkingspace.pojos;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

import lombok.Getter;
import lombok.Setter;

public abstract class ResourceAbstract {

    @Getter
    @Setter
    protected long id;

    @Getter
    @Setter
    protected String TYPE; // ResourceType TYPE; --- Should this be an enum, ResourceType?

    @Getter
    @Setter
    protected String name;

    @Getter
    @Setter
    protected String description;

    @Getter
    @Setter
    protected int available;

    @Getter
    @Setter
    protected double price;

    /**
     * Checks if the resource is available.
     * 
     * @return true if the resource is available (i.e., the quantity is greater than zero), false otherwise.
     */
    public boolean isAvailable() {
        return available > 0;
    }

    /**
     * Returns a summary of the resource, useful for logging or displaying information.
     * <p>
     * The summary will be in the format of a JSON object, with the following fields:
     * <ul>
     *     <li>id: the unique identifier of the resource</li>
     *     <li>TYPE: the type of the resource, e.g. "Display", "Audio", etc.</li>
     *     <li>name: the name of the resource</li>
     *     <li>description: a brief description of the resource</li>
     *     <li>available: the number of resources available</li>
     *     <li>price: the price of the resource in dollars</li>
     * </ul>
     * </p>
     */
    public String getSummary() {
        return "Resource{\n" +
                "id = " + id +
                ", TYPE = '" + TYPE + '\'' +
                ", name = '" + name + '\'' +
                ", description = '" + description + '\'' +
                ", available = " + available +
                ", price = $" + price +
                "\n}";
    }

    /**
     * Compares this resource with another resource to determine equality.
     *
     * @param resource the resource to compare with this resource
     * @return true if the IDs of both resources are equal, false otherwise
     */
    public boolean equals(ResourceAbstract resource) {
        return this.id == resource.getId();
    }

    /**
     * Attempts to reserve one resource, if available.
     * <p>
     * If there is at least one resource available, this method will decrement the available count by one and return true.
     * Otherwise, it will return false.
     * </p>
     * @return true if the resource was reserved, false if not
     */
    public boolean reserveOne() {
        if (available > 0) {
            available--;
            return true;
        }
        return false;
    }

    /**
     * Attempts to reserve multiple resources, if available.
     * <p>
     * If there are at least <code>quantity</code> resources available, this method will decrement the available count by <code>quantity</code> and return true.
     * Otherwise, it will return false.
     * </p>
     * @param quantity the number of resources to reserve
     * @return true if the resources were reserved, false if not
     */
    public boolean reserve(int quantity) {
        if (available >= quantity) {
            available -= quantity;
            return true;
        }
        return false;
    }

    /**
     * Attempts to return one resource, if not already fully reserved.
     * <p>
     * If there are available resources, this method will increment the available count by one and return true.
     * Otherwise, it will return false.
     * </p>
     * @return true if the resource was returned, false if not
     */
    public boolean returnOne() {
        available++;
        return true;
    }

}
