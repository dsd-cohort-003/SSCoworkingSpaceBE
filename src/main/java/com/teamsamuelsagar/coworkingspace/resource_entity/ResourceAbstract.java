package com.teamsamuelsagar.coworkingspace.resource_entity;

// import com.teamsamuelsagar.coworkingspace.pojos.ResourceCategory;
// import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resources")
public abstract class ResourceAbstract {

    @Id
    @Column(name = "id")
    protected long id;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    protected ResourceCategory CATEGORY; // The Category the resource belongs to

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    protected ResourceType TYPE; // The Type of resource

    @Column(name = "name")
    protected String name;

    @Column(name = "available")
    protected int available;

    @Column(name = "price")
    protected Float price;

    @Column(name = "description")
    protected String description; // The JSON description for the specific resource

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
     *     <li>CATEGORY: the category of the resource, e.g. "Display", "Audio", etc.</li>
     *     <li>TYPE: the type of the resource, e.g. "Monitor", "Microphone", etc.</li>
     *     <li>name: the name of the resource</li>
     *     <li>description: a brief description of the resource</li>
     *     <li>available: the number of resources available</li>
     *     <li>price: the price of the resource in dollars</li>
     * </ul>
     * </p>
     */
    public String getSummary() {
        return "Resource{\n" +
                "    id=" + id + "\n" +
                "    CATEGORY=" + CATEGORY + "\n" +
                "    TYPE=" + TYPE + "\n" +
                "    name='" + name + '\'' + "\n" +
                "    available=" + available + "\n" +
                "    price=" + price + "\n" +
                "    description='" + description +
                '}';
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
