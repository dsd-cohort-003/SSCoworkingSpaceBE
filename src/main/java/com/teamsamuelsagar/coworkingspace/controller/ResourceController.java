package com.teamsamuelsagar.coworkingspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.model.resource_entity.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.resource_entity.Resource;
import com.teamsamuelsagar.coworkingspace.model.resource_entity.ResourceType;
import com.teamsamuelsagar.coworkingspace.service.ResourceService;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/")
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

    @GetMapping("/id/{id}")
    public Resource getResourceById(int id) {
        return resourceService.getResourceById(id);
    }

    @GetMapping("/category/{category}")
    public List<Resource> getResourcesByCategory(ResourceCategory category) {
        return resourceService.getResourcesByCategory(category);
    }

    @GetMapping("/type/{type}")
    public List<Resource> getResourcesByType(ResourceType type) {
        return resourceService.getResourcesByType(type);
    }

}
