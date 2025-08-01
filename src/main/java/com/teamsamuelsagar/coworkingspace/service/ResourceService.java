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

    @Autowired
    private ResourceReservationService resourceReservationService;

    public ResourceDTO getResourceById(long officeId, String startDate, String endDate, long id) {
            return toDTO(resourceRepository.findByIdAndOfficeId(id, officeId), startDate, endDate);
    }

    public List<ResourceDTO> getAllByCategory(long officeId, String startDate, String endDate, ResourceCategory category) {
        return resourceRepository.findByCategoryAndOfficeId(category, officeId)
            .stream()
            .map(resource -> toDTO(resource, startDate, endDate))
            .collect(Collectors.toList());
    }

    public List<ResourceDTO> getResourcesByType(long officeId, String startDate, String endDate, ResourceType type) {
        return resourceRepository.findByTypeAndOfficeId(type, officeId)
            .stream()
            .map(resource -> toDTO(resource, startDate, endDate))
            .collect(Collectors.toList());
    }

    public List<ResourceDTO> getResourcesByOfficeId(long officeId, String startDate, String endDate) {
        return resourceRepository.findByOfficeId(officeId)
            .stream()
            .map(resource -> toDTO(resource, startDate, endDate))
            .collect(Collectors.toList());
    }

    private ResourceDTO toDTO(Resource entity, String startDate, String endDate) {
        ResourceDTO dto = new ResourceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getType());
        dto.setCategory(entity.getCategory());
        dto.setReserved(resourceReserved(entity, startDate, endDate));
        return dto;
    }

    private boolean resourceReserved(Resource entity, String startDate, String endDate) {
        return resourceReservationService.getReservationByResourceId(entity.getId(), startDate, endDate).isEmpty();
    }

}
