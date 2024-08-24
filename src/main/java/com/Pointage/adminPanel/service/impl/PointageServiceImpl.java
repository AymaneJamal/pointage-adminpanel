package com.Pointage.adminPanel.service.impl;

import com.Pointage.adminPanel.model.Pointage;
import com.Pointage.adminPanel.repository.PointageRepository;
import com.Pointage.adminPanel.service.PointageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointageServiceImpl implements PointageService {

    @Autowired
    private PointageRepository pointageRepository;

    @Override
    public Pointage savePointage(Pointage pointage) {
        return pointageRepository.save(pointage);
    }

    @Override
    public List<Pointage> getAllPointages() {
        return pointageRepository.findAll();
    }

    @Override
    public Pointage getPointageById(Long id) {
        return pointageRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePointage(Long id) {
        pointageRepository.deleteById(id);
    }
}
