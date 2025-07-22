package com.teamsamuelsagar.coworkingspace.mightuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.mightuse.repository.OfficeRepository;

@Service
public class OfficeService {
    @Autowired
    private OfficeRepository officeRepository;

    public String getOfficeDetails() {
        // Logic to retrieve office details
        return "Office details";
    }
    
}
