package com.teamsamuelsagar.coworkingspace.resource_repository;

import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceAbstract;
import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.resource_entity.ResourceType;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<ResourceAbstract, Integer> {
    @NonNull
    List<ResourceAbstract> findAll();

    Optional<ResourceAbstract> findById(int id);

    List<ResourceAbstract> findByCategory(ResourceCategory category);

    List<ResourceAbstract> findByType(ResourceType type);

}
