package com.teamsamuelsagar.coworkingspace.mightuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.mightuse.service.ResourceService;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    @GetMapping("/")
    public ResponseEntity<String> getAllResources() {
        String resourcesList = resourceService.getAllResources();
        // Logic to retrieve all resources
        return ResponseEntity.ok(resourcesList);
    }
}
