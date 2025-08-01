package com.teamsamuelsagar.coworkingspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;
import com.teamsamuelsagar.coworkingspace.service.ResourceService;
import com.teamsamuelsagar.coworkingspace.dto.ResourceDTO;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/{officeId}")
    public List<ResourceDTO> getAllResources(long officeId) {
        return resourceService.getResourcesByOfficeId(officeId);
    }

    @GetMapping("/{officeId}/id/{id}")
    public ResourceDTO getResourceById(long officeId, long id) {
        return resourceService.getResourceById(officeId, id);
    }

    @GetMapping("/{officeId}/category/{category}")
    public List<ResourceDTO> getResourcesByCategory(long officeId, ResourceCategory category) {
        return resourceService.getAllByCategory(officeId, category);
    }

    @GetMapping("/{officeId}/type/{type}")
    public List<ResourceDTO> getResourcesByType(long officeId, ResourceType type) {
        return resourceService.getResourcesByType(officeId, type);
    }

}
