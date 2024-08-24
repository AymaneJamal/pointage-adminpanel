package com.Pointage.adminPanel.repository;

import com.Pointage.adminPanel.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Optional<Employe> findByQrCodeNFCId(String qrCodeNFCId);

    boolean existsByQrCodeNFCId(String qrCodeNFCId);


}
