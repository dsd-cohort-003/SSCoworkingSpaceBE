package com.teamsamuelsagar.coworkingspace.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReservationRequestDTO {
    private String username;
    private BigDecimal totalPrice;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
