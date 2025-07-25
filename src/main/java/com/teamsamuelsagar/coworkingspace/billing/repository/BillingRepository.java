package com.teamsamuelsagar.coworkingspace.billing.repository;

import com.teamsamuelsagar.coworkingspace.billing.entity.Billing;
import com.teamsamuelsagar.coworkingspace.billing.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
    List<Billing> findByUser(User user);
    List<Billing> findByUserAndIsPaidFalse(User user);
}
