package com.Pointage.adminPanel.service.impl;

import com.Pointage.adminPanel.model.Employe;
import com.Pointage.adminPanel.repository.EmployeRepository;
import com.Pointage.adminPanel.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements EmployeService {

    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Optional<Employe> findByQrCodeNFCId(String qrCodeNFCId) {
        return employeRepository.findByQrCodeNFCId(qrCodeNFCId);
    }


    public boolean existsByQrCodeNFCId(String qrCodeNFCId) {
        return employeRepository.existsByQrCodeNFCId(qrCodeNFCId);
    }

}
