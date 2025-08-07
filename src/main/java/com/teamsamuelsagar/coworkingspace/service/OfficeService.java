package com.teamsamuelsagar.coworkingspace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.dto.OfficeDTO;
import com.teamsamuelsagar.coworkingspace.model.Office;
import com.teamsamuelsagar.coworkingspace.repository.OfficeRepository;
import lombok.RequiredArgsConstructor;
import jakarta.persistence.EntityNotFoundException;


@Service
@RequiredArgsConstructor
public class OfficeService {
    private final OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office createOffice(OfficeDTO dto) {
        Office office = new Office();
        office.setName(dto.getName());
        office.setPrice(dto.getPrice());
        office.setSize(dto.getSize());
        office.setState(dto.getState());
        office.setCity(dto.getCity());
        office.setDescription(dto.getDescription());
        office.setStreetAddress(dto.getStreetAddress());
        office.setZipcode(dto.getZipcode());
        return officeRepository.save(office);
    }

    public Office editOffice(Long id, OfficeDTO dto) {
        Office office = getOfficeById(id);
        office.setName(dto.getName());
        office.setPrice(dto.getPrice());
        office.setSize(dto.getSize());
        office.setState(dto.getState());
        office.setCity(dto.getCity());
        office.setDescription(dto.getDescription());
        office.setStreetAddress(dto.getStreetAddress());
        office.setZipcode(dto.getZipcode());
        return officeRepository.save(office);
    }

    public Office getOfficeById(long officeId) {
        return officeRepository.findById(officeId).orElseThrow(EntityNotFoundException::new);
    }

    public Office createOffice(Office office) {
        return officeRepository.save(office);
    }

    public void deleteOffice(Long officeId) {
        if(officeRepository.existsById(officeId)) {
            officeRepository.deleteById(officeId);
        } else {
            throw new EntityNotFoundException();
        }
    }    
}