package com.Pointage.adminPanel.repository;

import com.Pointage.adminPanel.model.Pointage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PointageRepository extends JpaRepository<Pointage, Long> {
}