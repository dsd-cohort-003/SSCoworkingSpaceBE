package com.teamsamuelsagar.coworkingspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/")
    public List<ResourceDTO> getAllResources(@RequestParam long officeId, @RequestParam String startDate, @RequestParam String endDate ) {
        return resourceService.getResourcesByOfficeId(officeId, startDate, endDate);
    }

    @GetMapping("{id}")
    public ResourceDTO getResourceById(@RequestParam long officeId, @RequestParam String startDate, @RequestParam String endDate, @RequestParam long id) {
        return resourceService.getResourceById(officeId, startDate, endDate, id);
    }

    @GetMapping("{category}")
    public List<ResourceDTO> getResourcesByCategory(@RequestParam long officeId, @RequestParam String startDate, @RequestParam String endDate, @RequestParam ResourceCategory category) {
        return resourceService.getAllByCategory(officeId, startDate, endDate, category);
    }

    @GetMapping("{type}")
    public List<ResourceDTO> getResourcesByType(@RequestParam long officeId, @RequestParam String startDate, @RequestParam String endDate, @RequestParam ResourceType type) {
        return resourceService.getResourcesByType(officeId, startDate, endDate, type);
    }

}
