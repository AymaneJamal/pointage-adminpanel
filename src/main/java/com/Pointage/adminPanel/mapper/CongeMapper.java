package com.Pointage.adminPanel.mapper;

import com.Pointage.adminPanel.dto.CongeDto;
import com.Pointage.adminPanel.model.Conge;
import com.Pointage.adminPanel.model.Employe;
import com.Pointage.adminPanel.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CongeMapper {

    @Autowired
    private EmployeRepository employeRepository;

    public CongeDto toDTO(Conge conge) {
        CongeDto dto = new CongeDto();
        dto.setId(conge.getId());
        dto.setEmployeId(conge.getEmploye().getId());
        dto.setDateDebut(conge.getDateDebut());
        dto.setDateFin(conge.getDateFin());
        dto.setType(conge.getType());
        return dto;
    }

    public Conge toEntity(CongeDto dto) {
        Conge conge = new Conge();
        Employe employe = employeRepository.findById(dto.getEmployeId()).orElse(null);
        if (employe != null) {
            conge.setEmploye(employe);
        }
        conge.setId(dto.getId());
        conge.setDateDebut(dto.getDateDebut());
        conge.setDateFin(dto.getDateFin());
        conge.setType(dto.getType());
        return conge;
    }
}

