package com.teamsamuelsagar.coworkingspace.service;



import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;
import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.dto.ResourceDTO;
import com.teamsamuelsagar.coworkingspace.repository.ResourceRepository;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private ResourceReservationService resourceReservationService;

    public ResourceDTO getResourceById(long officeId, LocalDate startDate, LocalDate endDate, long id) {
            return toDTO(resourceRepository.findByIdAndOfficeId(id, officeId), startDate, endDate);
    }

    public List<ResourceDTO> getAllByCategory(long officeId, LocalDate startDate, LocalDate endDate, ResourceCategory category) {
        return resourceRepository.findByCategoryAndOfficeId(category, officeId)
            .stream()
            .map(resource -> toDTO(resource, startDate, endDate))
            .collect(Collectors.toList());
    }

    public List<ResourceDTO> getResourcesByType(long officeId, LocalDate startDate, LocalDate endDate, ResourceType type) {
        return resourceRepository.findByTypeAndOfficeId(type, officeId)
            .stream()
            .map(resource -> toDTO(resource, startDate, endDate))
            .collect(Collectors.toList());
    }

    public List<ResourceDTO> getResourcesByOfficeId(long officeId, LocalDate startDate, LocalDate endDate) {
        return resourceRepository.findByOfficeId(officeId)
            .stream()
            .map(resource -> toDTO(resource, startDate, endDate))
            .collect(Collectors.toList());
    }
    
    public Resource createResource(ResourceDTO resource) {
        return resourceRepository.save(toResource(resource));
    }

    private ResourceDTO toDTO(Resource entity, LocalDate startDate, LocalDate endDate) {
        ResourceDTO dto = new ResourceDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setType(entity.getType());
        dto.setCategory(entity.getCategory());
        dto.setReserved(resourceReserved(entity, startDate, endDate));
        return dto;
    }

    private boolean resourceReserved(Resource entity, LocalDate startDate, LocalDate endDate) {
        return resourceReservationService.getReservationByResourceId(entity.getId(), startDate, endDate).isEmpty();
    }

    private Resource toResource(ResourceDTO resource) {
        Resource entity = new Resource();
        entity.setOfficeId(resource.getOfficeId());
        entity.setId(resource.getId());
        entity.setName(resource.getName());
        entity.setDescription(resource.getDescription());
        entity.setPrice(resource.getPrice());
        entity.setType(resource.getType());
        entity.setCategory(resource.getCategory());
        return entity;
    }

}
