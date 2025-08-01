package com.teamsamuelsagar.coworkingspace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.teamsamuelsagar.coworkingspace.dto.OfficeDTO;
import com.teamsamuelsagar.coworkingspace.model.Office;
import com.teamsamuelsagar.coworkingspace.repository.OfficeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfficeService {
    private final OfficeRepository officeRepository;

    public List<Office> getAllOffices() {
        return officeRepository.findAll();
    }

    public Office getOfficeById(Long id) {
        return officeRepository.findById(id).orElseThrow();
    }

    public Office createOffice(OfficeDTO dto) {
        Office office = new Office();
        office.setName(dto.getName());
        office.setPrice(dto.getPrice());
        office.setSize(dto.getSize());
        return officeRepository.save(office);
    }

    public Office editOffice(Long id, OfficeDTO dto) {
        Office office = getOfficeById(id);
        office.setName(dto.getName());
        office.setPrice(dto.getPrice());
        office.setSize(dto.getSize());
        return officeRepository.save(office);
    }

    public void deleteOffice(Long id) {
        Office office = getOfficeById(id);
        officeRepository.delete(office);
    }
}
