package com.Pointage.adminPanel.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CongeDto {
    private Long id;
    private Long employeId;
    private Date dateDebut;
    private Date dateFin;
    private String type;
}

