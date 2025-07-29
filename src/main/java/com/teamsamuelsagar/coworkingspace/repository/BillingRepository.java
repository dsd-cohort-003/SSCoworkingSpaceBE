package com.teamsamuelsagar.coworkingspace.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teamsamuelsagar.coworkingspace.entity.Billing;
import com.teamsamuelsagar.coworkingspace.entity.User;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findByUser(User user);
    List<Billing> findByUserAndIsPaidFalse(User user);
}
