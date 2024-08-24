package com.Pointage.adminPanel.service;

import com.Pointage.adminPanel.model.Pointage;

import java.util.List;

public interface PointageService {
    Pointage savePointage(Pointage pointage);
    List<Pointage> getAllPointages();
    Pointage getPointageById(Long id);
    void deletePointage(Long id);
}
