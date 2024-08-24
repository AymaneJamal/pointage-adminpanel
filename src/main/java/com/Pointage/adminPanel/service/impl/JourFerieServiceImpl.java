package com.Pointage.adminPanel.service.impl;

import com.Pointage.adminPanel.model.JourFerie;
import com.Pointage.adminPanel.repository.JourFerieRepository;
import com.Pointage.adminPanel.service.JourFerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JourFerieServiceImpl implements JourFerieService {

    @Autowired
    private JourFerieRepository jourFerieRepository;

    @Override
    public JourFerie saveJourFerie(JourFerie jourFerie) {
        return jourFerieRepository.save(jourFerie);
    }

    @Override
    public List<JourFerie> getAllJourFeries() {
        return jourFerieRepository.findAll();
    }

    @Override
    public JourFerie getJourFerieById(Long id) {
        return jourFerieRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJourFerie(Long id) {
        jourFerieRepository.deleteById(id);
    }
}
