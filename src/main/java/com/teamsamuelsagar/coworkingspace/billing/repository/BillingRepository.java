package com.teamsamuelsagar.coworkingspace.billing.repository;

import com.teamsamuelsagar.coworkingspace.billing.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Billing, Long> {
}
