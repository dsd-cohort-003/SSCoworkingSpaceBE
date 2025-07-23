package com.teamsamuelsagar.coworkingspace.billing.service;

import com.teamsamuelsagar.coworkingspace.billing.entity.Billing;
import com.teamsamuelsagar.coworkingspace.billing.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    public Optional<Billing> getBillById(Long id) {
        return billingRepository.findById(id);
    }

    public Billing createBill(Billing bill) {

        return billingRepository.save(bill);
    }
}
