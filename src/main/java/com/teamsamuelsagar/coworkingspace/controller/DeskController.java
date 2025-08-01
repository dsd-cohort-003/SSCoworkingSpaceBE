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

import com.teamsamuelsagar.coworkingspace.dto.RetrieveDesksRequest;
import com.teamsamuelsagar.coworkingspace.model.Desk;
import com.teamsamuelsagar.coworkingspace.service.DeskService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DeskController {
    private final DeskService deskService;


    @GetMapping(value = "/desks")
    public ResponseEntity<List<Desk>> getAllDesks() {
        return ResponseEntity.ok(deskService.getAllDesks());
    }

    @GetMapping(value = "/desks/{officeId}")
    public ResponseEntity<List<Desk>> getAllDesksForOffice(@PathVariable Long officeId) {
        return ResponseEntity.ok(deskService.getAllDesksForOffice(officeId));
    }

    @PostMapping(value = "/desks")
    public ResponseEntity<Desk> createDesk(@RequestBody Desk request) {
        return ResponseEntity.ok(deskService.createDesk(request));
    }

    @PostMapping(value = "/desks/{officeId}")
    public ResponseEntity<List<Desk>> getDesksForOffice(@PathVariable Long officeId, @RequestBody RetrieveDesksRequest request) {
        return ResponseEntity.ok(deskService.getDesksForOffice(request, officeId));
    }

    @DeleteMapping(value = "/desks/{deskId}")
    public ResponseEntity<Void> deleteDesk(@PathVariable long deskId) {
        deskService.deleteDesk(deskId);
        return ResponseEntity.noContent().build();
    }

}