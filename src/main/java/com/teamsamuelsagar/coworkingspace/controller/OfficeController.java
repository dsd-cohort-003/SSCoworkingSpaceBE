package com.teamsamuelsagar.coworkingspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.dto.OfficeDTO;
import com.teamsamuelsagar.coworkingspace.model.Office;
import com.teamsamuelsagar.coworkingspace.service.OfficeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = { "/api/office", "/offices"})   // for compatibility
@RequiredArgsConstructor
public class OfficeController {
    private final OfficeService officeService;

    @GetMapping
    public ResponseEntity<List<Office>> getAllOffices() {
        return ResponseEntity.ok(officeService.getAllOffices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Office> getOfficeById(@PathVariable Long id) {
        return ResponseEntity.ok(officeService.getOfficeById(id));
    }

    @PostMapping
    public ResponseEntity<Office> createOffice(@RequestBody OfficeDTO dto) {
        return ResponseEntity.ok(officeService.createOffice(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Office> editOffice(@PathVariable Long id, @RequestBody OfficeDTO dto) {
        return ResponseEntity.ok(officeService.editOffice(id, dto));
    }

    // TODO change to confirm deletion
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffice(@PathVariable Long id) {
        if (officeService.getOfficeById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        officeService.deleteOffice(id);
        return ResponseEntity.noContent().build();
    }
}

