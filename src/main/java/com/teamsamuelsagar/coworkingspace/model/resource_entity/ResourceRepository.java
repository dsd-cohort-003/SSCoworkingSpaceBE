package com.teamsamuelsagar.coworkingspace.model.resource_entity;

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
