package com.teamsamuelsagar.coworkingspace.resource_controller;

import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceAbstract;
import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceType;
import com.teamsamuelsagar.coworkingspace.resource_service.ResourceService;

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
    public List<ResourceAbstract> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/id/{id}")
    public ResourceAbstract getResourceById(int id) {
        return resourceService.getResourceById(id);
    }

    @GetMapping("/category/{category}")
    public List<ResourceAbstract> getResourcesByCategory(ResourceCategory category) {
        return resourceService.getResourcesByCategory(category);
    }

    @GetMapping("/type/{type}")
    public List<ResourceAbstract> getResourcesByType(ResourceType type) {
        return resourceService.getResourcesByType(type);
    }

}
