package com.Pointage.adminPanel.controller;

import com.Pointage.adminPanel.AuthController.AuthenticationService;
import com.Pointage.adminPanel.dto.PointageDto;
import com.Pointage.adminPanel.mapper.PointageMapper;
import com.Pointage.adminPanel.model.Employe;
import com.Pointage.adminPanel.model.Pointage;
import com.Pointage.adminPanel.model.PointageRequest;
import com.Pointage.adminPanel.model.User;
import com.Pointage.adminPanel.service.EmployeService;
import com.Pointage.adminPanel.service.PointageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/machine")
@RequiredArgsConstructor
public class PointageController {

    private final PointageService pointageService;
    private final PointageMapper pointageMapper;
    private final AuthenticationService authService;
    private final EmployeService employeService;

    @PostMapping("/pointage")
    public ResponseEntity<?> createPointage(@RequestBody PointageRequest pointageRequest,
                                            @RequestHeader(HttpHeaders.AUTHORIZATION) String token) {
        // Recherche de l'employé par son QR code
        Optional<Employe> optionalEmploye = employeService.findByQrCodeNFCId(pointageRequest.getQrCode());
        if (optionalEmploye.isEmpty()) {
            return ResponseEntity.badRequest().body("Employé non trouvé pour le QR code fourni");
        }

        Employe employe = optionalEmploye.get();
        User machine = authService.getUserFromToken(token.replace("Bearer ", ""));

        // Construction du PointageDto
        PointageDto pointageDto = new PointageDto();
        pointageDto.setEmployeId(employe.getId());
        pointageDto.setMachineId(machine.getId());
        pointageDto.setType(pointageRequest.getType());
        pointageDto.setDate(new Date());

        // Sauvegarde du pointage
        Pointage pointage = pointageMapper.toEntity(pointageDto);
        Pointage createdPointage = pointageService.savePointage(pointage);
        PointageDto responseDto = pointageMapper.toDto(createdPointage);

        return ResponseEntity.ok(responseDto);
    }
}