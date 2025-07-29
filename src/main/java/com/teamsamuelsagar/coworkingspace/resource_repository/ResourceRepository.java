package com.teamsamuelsagar.coworkingspace.resource_repository;

import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceEntity;
import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceType;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceEntity, Integer> {
    @NonNull
    List<ResourceEntity> findAll();

    Optional<ResourceEntity> findById(int id);

    List<ResourceEntity> findByCategory(ResourceCategory category);

    List<ResourceEntity> findByType(ResourceType type);

}
