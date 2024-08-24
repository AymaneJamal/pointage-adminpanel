package com.Pointage.adminPanel.dto;

import lombok.Data;

import java.util.Date;

@Data
public class JourFerieDto {
    private Long id;
    private Date date;
    private String description;
}