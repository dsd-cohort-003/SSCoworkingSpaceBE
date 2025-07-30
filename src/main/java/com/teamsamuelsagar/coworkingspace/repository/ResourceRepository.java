package com.teamsamuelsagar.coworkingspace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.resource_entity.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.resource_entity.Resource;
import com.teamsamuelsagar.coworkingspace.model.resource_entity.ResourceType;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    @NonNull
    List<Resource> findAll();

    Optional<Resource> findById(int id);

    List<Resource> findByCategory(ResourceCategory category);

    List<Resource> findByType(ResourceType type);

}
