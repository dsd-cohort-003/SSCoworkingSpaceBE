package com.teamsamuelsagar.coworkingspace.billing.service;

import com.teamsamuelsagar.coworkingspace.billing.entity.Billing;
import com.teamsamuelsagar.coworkingspace.billing.entity.OfficeReservation;
import com.teamsamuelsagar.coworkingspace.billing.entity.User;
import com.teamsamuelsagar.coworkingspace.billing.repository.BillingRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BillingService {
    private final BillingRepository billingRepository;
    private final UserService userService;
    private final OfficeReservationService reservationService;

    public List<Billing> getAllBills() {
        return billingRepository.findAll();
    }

    public Optional<Billing> getBillById(Long id) {
        return billingRepository.findById(id);
    }

    public Billing createBill(Billing bill) {
        return billingRepository.save(bill);
    }

    public Billing getBillingById(Long id) {
        return billingRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Billing ID not found"));
    }

    public List<Billing> getBillingByUserId(Long userId) {
        User user = userService.getUserById(userId); // delegate responsibility
        return billingRepository.findByUser(user);
    }

    public List<Billing> getUnpaidBillingByUserId(Long userId) {
        User user = userService.getUserById(userId);
        return billingRepository.findByUserAndIsPaidFalse(user);
    }

    public String processPayment(Long billingId) {
        // Stub logic – payment gateway can be added here later
        Billing bill = billingRepository.findById(billingId)
            .orElseThrow(() -> new IllegalArgumentException("Billing ID not found"));
        return "Payment processing initiated for billing ID " + bill.getId();
    }

    @Transactional
    public Billing confirmPayment(Long billingId) {
        Billing bill = billingRepository.findById(billingId)
            .orElseThrow(() -> new IllegalArgumentException("Billing ID not found"));
        bill.setIsPaid(true);
        return billingRepository.save(bill);
    }

    public Billing generateBill(Long reservationId) {
        OfficeReservation reservation = reservationService.getReservationById(reservationId);
        double hours = Duration.between(reservation.getStartDate(), reservation.getEndDate()).toHours();
        double rate = reservation.getOffice().getPrice();

        Billing bill = new Billing();
        bill.setReservation(reservation);
        bill.setUser(reservation.getUser());
        bill.setTotal((float) (rate * hours));
        bill.setIsPaid(false);

        return billingRepository.save(bill);
    }
}
