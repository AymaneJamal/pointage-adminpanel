package com.Pointage.adminPanel.mapper;

import com.Pointage.adminPanel.dto.EmployeDto;
import com.Pointage.adminPanel.model.Employe;
import org.springframework.stereotype.Component;

@Component
public class EmployeMapper {

    public EmployeDto toDTO(Employe employe) {
        EmployeDto dto = new EmployeDto();
        dto.setId(employe.getId());
        dto.setNom(employe.getNom());
        dto.setPrenom(employe.getPrenom());
        dto.setEmail(employe.getEmail());
        dto.setQrCodeNFCId(employe.getQrCodeNFCId());
        dto.setSoldeConge(employe.getSoldeConge());
        return dto;
    }

    public Employe toEntity(EmployeDto dto) {
        Employe employe = new Employe();
        employe.setId(dto.getId());
        employe.setNom(dto.getNom());
        employe.setPrenom(dto.getPrenom());
        employe.setEmail(dto.getEmail());
        employe.setQrCodeNFCId(dto.getQrCodeNFCId());
        employe.setSoldeConge(dto.getSoldeConge());
        return employe;
    }
}
