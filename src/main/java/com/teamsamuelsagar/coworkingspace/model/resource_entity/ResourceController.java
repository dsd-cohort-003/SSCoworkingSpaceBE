package com.teamsamuelsagar.coworkingspace.model.resource_entity;

import com.teamsamuelsagar.coworkingspace.service.ResourceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/")
    public List<ResourceEntity> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/id/{id}")
    public ResourceEntity getResourceById(int id) {
        return resourceService.getResourceById(id);
    }

    // @GetMapping("/category/{category}")
    // public List<ResourceEntity> getResourcesByCategory(ResourceCategory category) {
    //     return resourceService.getResourcesByCategory(category);
    // }

    // @GetMapping("/type/{type}")
    // public List<ResourceEntity> getResourcesByType(ResourceType type) {
    //     return resourceService.getResourcesByType(type);
    // }

}
