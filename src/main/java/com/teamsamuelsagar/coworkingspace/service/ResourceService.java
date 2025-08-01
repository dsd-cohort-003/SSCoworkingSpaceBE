package com.teamsamuelsagar.coworkingspace.service;

import com.teamsamuelsagar.coworkingspace.enums.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.enums.ResourceType;
import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.dto.ResourceDTO;
import com.teamsamuelsagar.coworkingspace.repository.ResourceRepository;

import java.util.List;
import java.util.stream.Collectors;

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

    public ResourceDTO getResourceById(long officeId, long id) {
            return toDTO(resourceRepository.findByIdAndOfficeId(id, officeId));
    }

    public List<ResourceDTO> getAllByCategory(long officeId, ResourceCategory category) {
        return resourceRepository.findByCategoryAndOfficeId(category, officeId)
            .stream()
            .map(resource -> toDTO(resource))
            .collect(Collectors.toList());
    }

    public List<ResourceDTO> getResourcesByType(long officeId, ResourceType type) {
        return resourceRepository.findByTypeAndOfficeId(type, officeId)
            .stream()
            .map(resource -> toDTO(resource))
            .collect(Collectors.toList());
    }

    public List<ResourceDTO> getResourcesByOfficeId(long officeId) {
        return resourceRepository.findByOfficeId(officeId)
            .stream()
            .map(resource -> toDTO(resource))
            .collect(Collectors.toList());
    }

    private ResourceDTO toDTO(Resource entity) {
        ResourceDTO dto = new ResourceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getType());
        dto.setCategory(entity.getCategory());
        dto.setReserved(resourceReserved(entity));
        return dto;
    }

    private boolean resourceReserved(Resource entity) {
        return false; // Stub until ResourceReservation is implemented
    }

}
