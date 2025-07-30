package com.teamsamuelsagar.coworkingspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;
import com.teamsamuelsagar.coworkingspace.repository.ResourceRepository;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

    public Resource getResourceById(int id) {
        return resourceRepository.findById(id).orElse(null);
    }

    public List<Resource> getResourcesByCategory(ResourceCategory category) {
        return resourceRepository.findByCategory(category);
    }

    public List<Resource> getResourcesByType(ResourceType type) {
        return resourceRepository.findByType(type);
    }

}
