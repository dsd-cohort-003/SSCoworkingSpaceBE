package com.teamsamuelsagar.coworkingspace.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.model.Billing;
import com.teamsamuelsagar.coworkingspace.service.BillingService;

import java.util.List;

@RestController
@RequestMapping("/api/billing")
@RequiredArgsConstructor
public class BillingController {

    @Autowired
    private final BillingService billingService;

    @GetMapping
    public ResponseEntity<List<Billing>> getAllBilling() {
        return ResponseEntity.ok(billingService.getAllBills());
    }

    @GetMapping("/{billingId}")
    public ResponseEntity<Billing> getBillingById(@PathVariable Long billingId) {
        return ResponseEntity.ok(billingService.getBillingById(billingId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Billing>> getBillingByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(billingService.getBillingByUserId(userId));
    }

    @GetMapping("/user/{userId}/unpaid")
    public ResponseEntity<List<Billing>> getUnpaidBilling(@PathVariable Long userId) {
        return ResponseEntity.ok(billingService.getUnpaidBillingByUserId(userId));
    }

    // Does nothing currently until payment processing is implemented
    @PostMapping("/pay/{billingId}/process")
    public ResponseEntity<String> processPayment(@PathVariable Long billingId) {
        return ResponseEntity.ok(billingService.processPayment(billingId));
    }

    @PostMapping("/pay/{billingId}/confirm")
    public ResponseEntity<Billing> confirmPayment(@PathVariable Long billingId) {
        return ResponseEntity.ok(billingService.confirmPayment(billingId));
    }

    @PostMapping("/generate/{reservationId}")
    public ResponseEntity<Billing> generateBill(@PathVariable Long reservationId) {
        return ResponseEntity.ok(billingService.generateBill(reservationId));
    }
}


