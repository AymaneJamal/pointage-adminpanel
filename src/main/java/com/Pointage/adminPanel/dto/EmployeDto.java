package com.Pointage.adminPanel.dto;

import lombok.Data;

@Data
public class EmployeDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String qrCodeNFCId;
    private int soldeConge;
}
