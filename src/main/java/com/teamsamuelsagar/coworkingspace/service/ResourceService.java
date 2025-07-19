package com.teamsamuelsagar.coworkingspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.repository.ResourceRepository;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public String getAllResources() {
        // Logic to retrieve all resources
        return "List of all resources";
    }
}
