package com.teamsamuelsagar.coworkingspace.billing.controller;

import com.teamsamuelsagar.coworkingspace.billing.dtos.BillingDTO;
import com.teamsamuelsagar.coworkingspace.billing.entity.Billing;
import com.teamsamuelsagar.coworkingspace.billing.service.BillingService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/billing")
@RequiredArgsConstructor
public class BillingController {
    private final BillingService billingService;

    // @GetMapping("/billing")
    // public ResponseEntity<List<BillingDTO>> getAllBills() {
    //     List<BillingDTO> bills = billingService.getAllBills()
    //             .stream()
    //             .map(bill -> createBillingDTO())
    //             .collect(Collectors.toList());

    //     return ResponseEntity.ok(bills);
    // }

    // @PostMapping("/billing")
    // public ResponseEntity<?> createBill(@RequestBody Billing bill) {
    //     Billing newBill = billingService.createBill(bill);

    //     if(newBill != null) {
    //         return ResponseEntity.status(201).body(newBill);
    //     }

    //     return ResponseEntity.badRequest().build();
    // }

    // @GetMapping("/billing/{reservation_id}")
    // public ResponseEntity<Optional<BillingDTO>> getBillById(@PathVariable String reservation_id) {
    //     Optional<Billing> bill = billingService.getBillById(Long.parseLong(reservation_id));

    //     if(bill.isPresent()) {
    //         return ResponseEntity.ok(Optional.of(createBillingDTO()));
    //     }

    //     return ResponseEntity.notFound().build();
    // }

    // private BillingDTO createBillingDTO() {
    //     BillingDTO newBillingDTO = new BillingDTO();

    //     newBillingDTO.setBillingId(1L);
    //     newBillingDTO.setReservationId(1L);
    //     newBillingDTO.setUsername("test user");
    //     newBillingDTO.setOfficeName("Office 1");
    //     newBillingDTO.setDeskName("Desk 1");
    //     newBillingDTO.setPrice(new BigDecimal(100.0));
    //     newBillingDTO.setStartDateTime(LocalDateTime.now());
    //     newBillingDTO.setEndDateTime(newBillingDTO.getStartDateTime().plusDays(30));

    //     return newBillingDTO;
    // }

    //===============================================

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


