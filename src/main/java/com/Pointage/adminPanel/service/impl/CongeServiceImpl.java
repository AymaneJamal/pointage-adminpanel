package com.Pointage.adminPanel.service.impl;

import com.Pointage.adminPanel.model.Conge;
import com.Pointage.adminPanel.repository.CongeRepository;
import com.Pointage.adminPanel.service.CongeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CongeServiceImpl implements CongeService {

    @Autowired
    private CongeRepository congeRepository;

    @Override
    public Conge saveConge(Conge conge) {
        return congeRepository.save(conge);
    }

    @Override
    public List<Conge> getAllConges() {
        return congeRepository.findAll();
    }

    @Override
    public Conge getCongeById(Long id) {
        return congeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteConge(Long id) {
        congeRepository.deleteById(id);
    }
}
