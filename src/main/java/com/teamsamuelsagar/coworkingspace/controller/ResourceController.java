package com.teamsamuelsagar.coworkingspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;
import com.teamsamuelsagar.coworkingspace.service.ResourceService;
import com.teamsamuelsagar.coworkingspace.dto.ResourceDTO;
import com.teamsamuelsagar.coworkingspace.dto.RetrieveResourceRequest;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/")
    public List<ResourceDTO> getAllResources(@RequestBody RetrieveResourceRequest request) {
        return resourceService.getResourcesByOfficeId(request.getOfficeId(), request.getStartDate(), request.getEndDate());
    }

    @GetMapping("/id")
    public ResourceDTO getResourceById(@RequestBody RetrieveResourceRequest request, @RequestParam Long id) {
        return resourceService.getResourceById(request.getOfficeId(), request.getStartDate(), request.getEndDate(), id);
    }

    @GetMapping("/category")
    public List<ResourceDTO> getResourcesByCategory(@RequestBody RetrieveResourceRequest request, @RequestParam ResourceCategory category) {
        return resourceService.getAllByCategory(request.getOfficeId(), request.getStartDate(), request.getEndDate(), category);
    }

    @GetMapping("/type")
    public List<ResourceDTO> getResourcesByType(@RequestBody RetrieveResourceRequest request, @RequestParam ResourceType type) {
        return resourceService.getResourcesByType(request.getOfficeId(), request.getStartDate(), request.getEndDate(), type);
    }

}
