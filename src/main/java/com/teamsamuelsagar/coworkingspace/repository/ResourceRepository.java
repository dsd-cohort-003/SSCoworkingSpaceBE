package com.teamsamuelsagar.coworkingspace.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Integer> {
    @NonNull
    List<Resource> findAll();

    Optional<Resource> findById(int id);

    List<Resource> findByCategory(ResourceCategory category);

    List<Resource> findByType(ResourceType type);
}
