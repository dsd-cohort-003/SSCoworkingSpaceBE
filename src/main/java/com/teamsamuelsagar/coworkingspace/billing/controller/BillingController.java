package com.teamsamuelsagar.coworkingspace.billing.controller;

import com.teamsamuelsagar.coworkingspace.billing.dtos.BillingDTO;
import com.teamsamuelsagar.coworkingspace.billing.entity.Billing;
import com.teamsamuelsagar.coworkingspace.billing.service.BillingService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    @GetMapping("/billing")
    public ResponseEntity<List<BillingDTO>> getAllBills() {
        List<BillingDTO> bills = billingService.getAllBills()
                .stream()
                .map(bill -> createBillingDTO())
                .collect(Collectors.toList());

        return ResponseEntity.ok(bills);
    }

    @PostMapping("/billing")
    public ResponseEntity<?> createBill(@RequestBody Billing bill) {
        Billing newBill = billingService.createBill(bill);

        if(newBill != null) {
            return ResponseEntity.status(201).body(newBill);
        }

        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/billing/{reservation_id}")
    public ResponseEntity<Optional<BillingDTO>> getBillById(@PathVariable String reservation_id) {
        Optional<Billing> bill = billingService.getBillById(Long.parseLong(reservation_id));

        if(bill.isPresent()) {
            return ResponseEntity.ok(Optional.of(createBillingDTO()));
        }

        return ResponseEntity.notFound().build();
    }

    private BillingDTO createBillingDTO() {
        BillingDTO newBillingDTO = new BillingDTO();

        newBillingDTO.setBillingId(1L);
        newBillingDTO.setReservationId(1L);
        newBillingDTO.setUsername("test user");
        newBillingDTO.setOfficeName("Office 1");
        newBillingDTO.setDeskName("Desk 1");
        newBillingDTO.setPrice(new BigDecimal(100.0));
        newBillingDTO.setStartDateTime(LocalDateTime.now());
        newBillingDTO.setEndDateTime(newBillingDTO.getStartDateTime().plusDays(30));

        return newBillingDTO;
    }
}


