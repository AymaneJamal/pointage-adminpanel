package com.Pointage.adminPanel.controller;


import com.Pointage.adminPanel.dto.EmployeDto;
import com.Pointage.adminPanel.mapper.EmployeMapper;
import com.Pointage.adminPanel.model.Employe;
import com.Pointage.adminPanel.service.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/admin/employe")
@RequiredArgsConstructor
public class EmployeController {

    private final EmployeService employeService;
    private final EmployeMapper employeMapper;

    // Create a new employee
    @PostMapping("/create")
    public ResponseEntity<EmployeDto> createEmploye(@RequestBody EmployeDto employeDto) {
        String nfcId = generateUniqueNfcId();
        Employe employe = employeMapper.toEntity(employeDto);
        employe.setQrCodeNFCId(nfcId);
        Employe createdEmploye = employeService.saveEmploye(employe);
        EmployeDto responseDto = employeMapper.toDTO(createdEmploye);
        return ResponseEntity.ok(responseDto);
    }

    // Update an existing employee
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeDto> updateEmploye(@PathVariable Long id, @RequestBody EmployeDto employeDto) {
        // Fetch the employee by ID (assuming this operation is required before updating)
        Employe existingEmploye = employeService.getEmployeById(id);
        if (existingEmploye == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the employee details
        employeDto.setId(id);  // Ensure the ID from the path is used
        Employe updatedEmploye = employeMapper.toEntity(employeDto);
        Employe savedEmploye = employeService.saveEmploye(updatedEmploye);
        EmployeDto responseDto = employeMapper.toDTO(savedEmploye);
        return ResponseEntity.ok(responseDto);
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        Employe existingEmploye = employeService.getEmployeById(id);
        if (existingEmploye == null) {
            return ResponseEntity.notFound().build();
        }
        employeService.deleteEmploye(id);
        return ResponseEntity.noContent().build();
    }

    // Retrieve a list of all employees
    @GetMapping
    public ResponseEntity<List<EmployeDto>> getAllEmployes() {
        List<EmployeDto> employeDtos = employeService.getAllEmployes().stream()
                .map(employeMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(employeDtos);
    }

    // Retrieve a single employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeDto> getEmployeById(@PathVariable Long id) {
        Employe employe = employeService.getEmployeById(id);
        if (employe == null) {
            return ResponseEntity.notFound().build();
        }
        EmployeDto employeDto = employeMapper.toDTO(employe);
        return ResponseEntity.ok(employeDto);
    }


    // Méthode pour générer un code NFC unique
    private String generateUniqueNfcId() {
        String nfcId;
        do {
            nfcId = generateNfcId();
        } while (employeService.existsByQrCodeNFCId(nfcId));  // Vérifier si le code existe déjà
        return nfcId;
    }

    // Méthode pour générer un code NFC aléatoire sécurisé
    private String generateNfcId() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[8];  // Taille du code NFC (par exemple, 8 octets)
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);  // Encodage en Base64URL
    }



}