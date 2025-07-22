package com.teamsamuelsagar.coworkingspace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamsamuelsagar.coworkingspace.entity.Desk;
import com.teamsamuelsagar.coworkingspace.service.DeskService;

@RestController
@RequestMapping("/api/desks")
public class DeskController {
    @Autowired
    private DeskService deskService;
    
    @GetMapping("/")
    public ResponseEntity<List<Desk>> getAllDesks() {
        List<Desk> list = deskService.getAllDesks();
        // Logic to retrieve all desks
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Desk> getDeskById(@PathVariable int id) throws Exception {
        Desk desk = deskService.getDeskById(id);
        // Logic to retrieve all desks
        return ResponseEntity.ok(desk);
    }
}