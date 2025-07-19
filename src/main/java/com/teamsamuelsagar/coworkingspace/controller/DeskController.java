package com.teamsamuelsagar.coworkingspace.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.service.DeskService;

@RestController
@RequestMapping("/api/desks")
public class DeskController {
    @Autowired
    private DeskService deskService;
    
    @GetMapping("/")
    public ResponseEntity<String> getAllDesks() {
        String list = deskService.getAllDesks();
        // Logic to retrieve all desks
        return ResponseEntity.ok(list);
    }
}