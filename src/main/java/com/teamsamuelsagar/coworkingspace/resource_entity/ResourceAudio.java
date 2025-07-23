package com.teamsamuelsagar.coworkingspace.resource_entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class ResourceAudio extends ResourceAbstract {

    @Getter
    @Setter
    private boolean isWireless;

}
