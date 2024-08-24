package com.Pointage.adminPanel.service;

import com.Pointage.adminPanel.model.Employe;

import java.util.List;
import java.util.Optional;

public interface EmployeService {
    Employe saveEmploye(Employe employe);
    List<Employe> getAllEmployes();
    Employe getEmployeById(Long id);
    void deleteEmploye(Long id);

    Optional<Employe> findByQrCodeNFCId(String qrCodeNFCId);

    boolean existsByQrCodeNFCId(String qrCodeNFCId);
}
