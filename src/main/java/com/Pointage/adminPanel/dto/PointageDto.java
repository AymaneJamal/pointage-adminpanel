package com.Pointage.adminPanel.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PointageDto {
    private Long id;
    private String type;
    private Long employeId;
    private Long machineId;  // Nouveau champ pour machineId
    private Date date;
}
