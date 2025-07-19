package com.teamsamuelsagar.coworkingspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.repository.DeskRepository;

@Service
public class DeskService {
    @Autowired
    private DeskRepository deskRepository;

    public String getAllDesks() {
        // Logic to retrieve all desks
        return "List of all desks";
    }
    
}
