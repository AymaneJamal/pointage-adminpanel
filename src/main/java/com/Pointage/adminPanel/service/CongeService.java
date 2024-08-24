package com.Pointage.adminPanel.service;

import com.Pointage.adminPanel.model.Conge;

import java.util.List;

public interface CongeService {
    Conge saveConge(Conge conge);
    List<Conge> getAllConges();
    Conge getCongeById(Long id);
    void deleteConge(Long id);
}
