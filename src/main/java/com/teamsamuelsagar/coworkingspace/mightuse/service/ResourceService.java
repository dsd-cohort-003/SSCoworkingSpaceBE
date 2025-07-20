package com.teamsamuelsagar.coworkingspace.mightuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.mightuse.repository.ResourceRepository;

@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;

    public String getAllResources() {
        // Logic to retrieve all resources
        return "List of all resources";
    }
}
