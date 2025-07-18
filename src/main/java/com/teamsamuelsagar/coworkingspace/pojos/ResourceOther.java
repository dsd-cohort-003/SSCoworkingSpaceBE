package com.teamsamuelsagar.coworkingspace.pojos;

import lombok.Getter;
import lombok.Setter;

//import com.teamsamuelsagar.coworkingspace.pojos.ResourceType;

public class ResourceOther extends ResourceAbstract {

    @Getter
    @Setter
    private String length;

    @Getter
    @Setter
    private String connectorType;

    @Getter
    @Setter
    private boolean surgeProtected;

    @Getter
    @Setter
    private String osType;

    @Getter
    @Setter
    private String printType;

    @Getter
    @Setter
    private boolean printColor;

    public ResourceOther() {
        this.TYPE = "Other"; // ResourceType.Other;
    }

    public ResourceOther(long id, int available, double price, String name, String description) {
        this.TYPE = "Other"; // ResourceType.Other;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public ResourceOther(long id, int available, double price, String name, String description, String length, String connectorType, boolean surgeProtected, String osType, String printType, boolean printColor) {
        this.TYPE = "Other"; // ResourceType.Other;
        this.id = id;
        this.available = available;
        this.price = price;
        this.name = name;
        this.description = description;
        this.length = length;
        this.connectorType = connectorType;
        this.surgeProtected = surgeProtected;
        this.osType = osType;
        this.printType = printType;
        this.printColor = printColor;
    }

    /**
     * Returns a summary of the resource, including Other-specific attributes.
     * <p>
     * The summary will be in the format of a JSON object, with the following fields:
     * <ul>
     *     <li>id: the unique identifier of the resource</li>
     *     <li>TYPE: the type of the resource, e.g. "Other"</li>
     *     <li>name: the name of the resource</li>
     *     <li>description: a brief description of the resource</li>
     *     <li>available: the number of resources available</li>
     *     <li>price: the price of the resource in dollars</li>
     *     <li>length: the length of the cable</li>
     *     <li>connectorType: the type of connector, e.g. HDMI, USB, etc.</li>
     *     <li>surgeProtected: whether the resource has surge protection</li>
     *     <li>osType: the type of operating system the resource is compatible with</li>
     *     <li>printType: the type of printing the resource supports</li>
     *     <li>printColor: whether the resource supports color printing</li>
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
                ", length = '" + length + '\'' +
                ", connectorType = '" + connectorType + '\'' +
                ", surgeProtected = " + surgeProtected +
                ", osType = '" + osType + '\'' +
                ", printType = '" + printType + '\'' +
                ", printColor = " + printColor +
                "\n}";
    }

}
