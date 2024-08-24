package com.Pointage.adminPanel.mapper;

import com.Pointage.adminPanel.dto.PointageDto;
import com.Pointage.adminPanel.model.Employe;
import com.Pointage.adminPanel.model.Pointage;
import com.Pointage.adminPanel.model.User;
import com.Pointage.adminPanel.repository.EmployeRepository;
import com.Pointage.adminPanel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PointageMapper {

    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private UserRepository userRepository;

    public PointageDto toDto(Pointage pointage) {
        PointageDto dto = new PointageDto();
        dto.setId(pointage.getId());
        dto.setType(pointage.getType());
        dto.setEmployeId(pointage.getEmploye().getId());
        dto.setMachineId(pointage.getMachine().getId());  // Ajoutez cette ligne
        dto.setDate(pointage.getDate());
        return dto;
    }

    public Pointage toEntity(PointageDto dto) {
        Pointage pointage = new Pointage();
        pointage.setId(dto.getId());
        pointage.setType(dto.getType());
        pointage.setDate(dto.getDate());

        Employe employe = employeRepository.findById(dto.getEmployeId()).orElseThrow(
                () -> new IllegalArgumentException("Employe not found")
        );
        pointage.setEmploye(employe);

        User machine = userRepository.findById(dto.getMachineId()).orElseThrow(
                () -> new IllegalArgumentException("Machine not found")
        );
        pointage.setMachine(machine);

        return pointage;
    }
}
