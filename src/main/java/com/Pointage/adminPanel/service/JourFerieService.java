package com.Pointage.adminPanel.service;

import com.Pointage.adminPanel.model.JourFerie;

import java.util.List;

public interface JourFerieService {
    JourFerie saveJourFerie(JourFerie jourFerie);
    List<JourFerie> getAllJourFeries();
    JourFerie getJourFerieById(Long id);
    void deleteJourFerie(Long id);
}
