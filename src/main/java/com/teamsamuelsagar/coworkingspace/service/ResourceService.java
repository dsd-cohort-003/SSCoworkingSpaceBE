package com.teamsamuelsagar.coworkingspace.service;

import com.teamsamuelsagar.coworkingspace.enums.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.models.ResourceEntity;
import com.teamsamuelsagar.coworkingspace.enums.ResourceType;
import com.teamsamuelsagar.coworkingspace.repository.ResourceRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<ResourceEntity> getAllResources() {
        return resourceRepository.findAll();
    }

    public ResourceEntity getResourceById(int id) {
        return resourceRepository.findById(id).orElse(null);
    }

    public List<ResourceEntity> getResourcesByCategory(ResourceCategory category) {
        return resourceRepository.findByCategory(category);
    }

    public List<ResourceEntity> getResourcesByType(ResourceType type) {
        return resourceRepository.findByType(type);
    }

}
