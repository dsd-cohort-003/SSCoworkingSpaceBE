package com.teamsamuelsagar.coworkingspace.mightuse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.mightuse.service.OfficeService;

@RestController
@RequestMapping("/api/office")
public class OfficeController {
    @Autowired
    private OfficeService officeService; 
    
    @GetMapping("/")
    public ResponseEntity<String> getOfficeDetails() {
        String officeDetails = officeService.getOfficeDetails();
        // Logic to retrieve office details
        return ResponseEntity.ok(officeDetails);
    }
}
