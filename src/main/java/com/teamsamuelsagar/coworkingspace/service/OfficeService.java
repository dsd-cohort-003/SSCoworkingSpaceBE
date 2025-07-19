package com.teamsamuelsagar.coworkingspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.repository.OfficeRepository;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    public String getOfficeDetails() {
        // Logic to retrieve office details
        return "Office details";
    }
    
}
