package com.teamsamuelsagar.coworkingspace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.entity.Desk;
import com.teamsamuelsagar.coworkingspace.repository.DeskRepository;

@Service
public class DeskService {
    @Autowired
    private DeskRepository deskRepository;

    public List<Desk> getAllDesks() {
        // Logic to retrieve all desks
        List<Desk> desks = deskRepository.findAll();    // findAll is implicit to JpaRepository
        return desks;
    }    

    public Desk getDeskById(int id) throws Exception {        
        // Logic to retrieve a desk by its ID
        Desk desk = deskRepository.findById(id);
        if (desk == null) {
            throw new Exception("Desk with ID " + id + " not found!");
        }
        return desk;
    }
}
