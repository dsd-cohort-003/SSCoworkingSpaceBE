package com.teamsamuelsagar.coworkingspace.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.model.Billing;
import com.teamsamuelsagar.coworkingspace.model.DeskReservation;
import com.teamsamuelsagar.coworkingspace.model.Reservation;
import com.teamsamuelsagar.coworkingspace.model.ResourceReservation;
import com.teamsamuelsagar.coworkingspace.model.User;
import com.teamsamuelsagar.coworkingspace.repository.BillingRepository;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillingService {
    private final BillingRepository billingRepository;
    private final UserService userService;
    private final ReservationService reservationService;
    private final ResourceReservationService resourceReservationService;
    // private final OfficeReservationService reservationService;

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

    public List<Billing> getBillingByAuthUserId(UUID authUserId) {
        User user = userService.getUserByAuthUserId(authUserId);
        return billingRepository.findByUserAndIsPaidFalse(user);
    }

    public List<Billing> getUnpaidBillingByAuthUserId(UUID authUserId) {
        User user = userService.getUserByAuthUserId(authUserId);
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
        Reservation reservation = reservationService.getReservationById(reservationId).orElseThrow();
        // Get price for desk reservation
        DeskReservation deskReservation = reservation.getDeskReservation();
        double deskHours = Duration.between(
            deskReservation.getStartDate().atStartOfDay(),
            deskReservation.getEndDate().atStartOfDay()
        ).toHours();
        
        double deskRate = deskReservation.getDesk().getPrice();
        double deskBill = deskHours * deskRate;

        // Get price for resource reservation
        List<ResourceReservation> resourceReservations = reservation.getResourceReservations();
        double resourceBill = 0.0;
        for (ResourceReservation resourceReservation : resourceReservations) {
            double resourceHours = Duration.between(
                resourceReservation.getStartDate().atStartOfDay(),
                resourceReservation.getEndDate().atStartOfDay()
            ).toHours();
            double resourceRate = resourceReservation.getResource().getPrice();
            resourceBill += (resourceHours * resourceRate);
        }
        
        // Calculate total bill
        Billing bill = new Billing();
        bill.setReservation(reservation);
        bill.setUser(reservation.getUser());
        bill.setTotal((float) (deskBill + resourceBill));
        bill.setIsPaid(false);

        return billingRepository.save(bill);
    }
}
