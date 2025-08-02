package com.teamsamuelsagar.coworkingspace.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.model.Office;
import com.teamsamuelsagar.coworkingspace.service.OfficeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OfficeController {
    private final OfficeService officeService;


    @GetMapping(value = "/offices")
    public ResponseEntity<List<Office>> getAllOffices() {
        return ResponseEntity.ok(officeService.getAllOffices());
        
    }

    @GetMapping(value = "/offices/{officeId}")
    public ResponseEntity<Office> getOfficeById(@PathVariable long officeId) {
        return ResponseEntity.ok(officeService.getOfficeById(officeId));
    }


    @PostMapping(value = "/offices")
    public ResponseEntity<Office> createOffice(@RequestBody Office request) {
        return ResponseEntity.ok(officeService.createOffice(request));
    }

    @DeleteMapping(value = "/offices/{officeId}") 
    public ResponseEntity<Void> deleteOffice(@PathVariable long officeId) {
        officeService.deleteOffice(officeId);
        return ResponseEntity.noContent().build();
    }

}