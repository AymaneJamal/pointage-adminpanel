package com.Pointage.adminPanel.mapper;

import com.Pointage.adminPanel.dto.JourFerieDto;
import com.Pointage.adminPanel.model.JourFerie;
import org.springframework.stereotype.Component;

@Component
public class JourFerieMapper {

    public JourFerieDto toDTO(JourFerie jourFerie) {
        JourFerieDto dto = new JourFerieDto();
        dto.setId(jourFerie.getId());
        dto.setDate(jourFerie.getDate());
        dto.setDescription(jourFerie.getDescription());
        return dto;
    }

    public JourFerie toEntity(JourFerieDto dto) {
        JourFerie jourFerie = new JourFerie();
        jourFerie.setId(dto.getId());
        jourFerie.setDate(dto.getDate());
        jourFerie.setDescription(dto.getDescription());
        return jourFerie;
    }
}
