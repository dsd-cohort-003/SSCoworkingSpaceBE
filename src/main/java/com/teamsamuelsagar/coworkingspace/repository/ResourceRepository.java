package com.teamsamuelsagar.coworkingspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.model.Resource;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceCategory;
import com.teamsamuelsagar.coworkingspace.model.enumtype.ResourceType;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {

    Resource findByIdAndOfficeId(long id, long officeId);

    List<Resource> findByCategoryAndOfficeId(ResourceCategory category, long officeId);

    List<Resource> findByTypeAndOfficeId(ResourceType type, long officeId);

    List<Resource> findByOfficeId(long officeId);

}
