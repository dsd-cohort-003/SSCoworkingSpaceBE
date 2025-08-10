package com.teamsamuelsagar.coworkingspace.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;
import com.teamsamuelsagar.coworkingspace.service.ResourceService;

import lombok.RequiredArgsConstructor;

import com.teamsamuelsagar.coworkingspace.dto.ResourceDTO;
import com.teamsamuelsagar.coworkingspace.dto.RetrieveResourceRequest;

@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
public class ResourceController {


    private final ResourceService resourceService;

    @GetMapping
    public List<ResourceDTO> getAllResources(@RequestBody RetrieveResourceRequest request) {
        return resourceService.getResourcesByOfficeId(request.getOfficeId(), request.getStartDate(), request.getEndDate());
    }

    @GetMapping("/id/{id}")
    public ResourceDTO getResourceById(@RequestBody RetrieveResourceRequest request, @PathVariable Long id) {
        return resourceService.getResourceById(request.getOfficeId(), request.getStartDate(), request.getEndDate(), id);
    }

    @GetMapping("/category/{category}")
    public List<ResourceDTO> getResourcesByCategory(@RequestBody RetrieveResourceRequest request, @PathVariable ResourceCategory category) {
        return resourceService.getAllByCategory(request.getOfficeId(), request.getStartDate(), request.getEndDate(), category);
    }

    @GetMapping("/type/{type}")
    public List<ResourceDTO> getResourcesByType(@RequestBody RetrieveResourceRequest request, @PathVariable ResourceType type) {
        return resourceService.getResourcesByType(request.getOfficeId(), request.getStartDate(), request.getEndDate(), type);
    }

    @PostMapping("/create")
    public ResponseEntity<Resource> createResource(@RequestBody ResourceDTO resource) {
        return ResponseEntity.ok(resourceService.createResource(resource));
    }

}
