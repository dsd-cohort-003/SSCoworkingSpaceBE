package com.teamsamuelsagar.coworkingspace.dto;

import com.teamsamuelsagar.coworkingspace.model.Resource;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ReservationRequestDTO {
    private String username;
    private BigDecimal totalPrice;

    private Long deskId;

    private String startDate;

    private String endDate;
    private List<Long> resourceIds;

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

    public Long getDeskId() {
        return deskId;
    }

    public void setDeskId(Long deskId) {
        this.deskId = deskId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Long> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }
}
