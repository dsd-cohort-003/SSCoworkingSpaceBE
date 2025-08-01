package com.teamsamuelsagar.coworkingspace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.dto.RetrieveDesksRequest;
import com.teamsamuelsagar.coworkingspace.model.Office;
import com.teamsamuelsagar.coworkingspace.model.Desk;
import com.teamsamuelsagar.coworkingspace.repository.DeskRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeskService {
    private final DeskRepository deskRepository;
    public List<Desk> getAllDesks() {
        return deskRepository.findAll();
    }

    public List<Desk> getAllDesksForOffice(Long officeId) {
        return deskRepository.findByOfficeId(officeId);
    }

    public List<Desk> getDesksForOffice(RetrieveDesksRequest request, Long officeId) {
        return deskRepository.findAvailableDesks(officeId, request.getStartDate(), request.getEndDate());
    }

    public Desk createDesk(Desk desk) {
        return deskRepository.save(desk);
    }

    public void deleteDesk(long deskId) {
        if(deskRepository.existsById(deskId)) {
            deskRepository.deleteById(deskId);
        } else {
            throw new EntityNotFoundException();
        }
    }
}