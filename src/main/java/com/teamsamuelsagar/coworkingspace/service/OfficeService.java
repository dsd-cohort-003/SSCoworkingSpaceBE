package com.teamsamuelsagar.coworkingspace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.model.Office;
import com.teamsamuelsagar.coworkingspace.repository.OfficeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class OfficeService {
    private final OfficeRepository officeRepository;


    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getOfficeById(long officeId) {
        return officeRepository.findById(officeId).orElseThrow(EntityNotFoundException::new);
    }

    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(long officeId) {
        if(officeRepository.existsById(officeId)) {
            officeRepository.deleteById(officeId);
        } else {
            throw new EntityNotFoundException();
        }
    }
    
}
