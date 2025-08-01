package com.teamsamuelsagar.coworkingspace.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

import com.teamsamuelsagar.coworkingspace.enums.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.enums.ResourceType;

import jakarta.persistence.Column;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resource")
public class Resource {

    @Id
    @Column(name = "id")
    protected long id;

    @Column(name = "office_id")
    protected long officeId;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    protected ResourceCategory category; // The Category of resource

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    protected ResourceType type; // The Type of resource

    @Column(name = "name")
    protected String name;

    @Column(name = "price")
    protected Float price;

    @Column(name = "description")
    protected String description; // The JSON description for the specific resource

    /**
     * Returns a summary of the resource, useful for logging or displaying information.
     * <p>
     * The summary will be in the format of a JSON object, with the following fields:
     * <ul>
     *     <li>id: the unique identifier of the resource</li>
     *     <li>officeId: the unique identifier of the office</li>
     *     <li>category: the category of the resource, e.g. "Computer", "Printer", etc.</li>
     *     <li>type: the type of the resource, e.g. "Monitor", "Microphone", etc.</li>
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
                "    officeId=" + officeId + "\n" +
                "    category=" + category + "\n" +
                "    type=" + type + "\n" +
                "    name='" + name + '\'' + "\n" +
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
    public boolean equals(Resource resource) {
        return this.id == resource.getId();
    }

}
