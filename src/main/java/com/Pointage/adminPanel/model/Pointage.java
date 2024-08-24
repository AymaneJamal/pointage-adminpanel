package com.Pointage.adminPanel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "pointage")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pointage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @ManyToOne
    @JoinColumn(name = "machine_id", nullable = false)  // Nouvelle colonne pour machine_id
    private User machine;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)  // Changement ici pour inclure date et heure
    private Date date;  // Garde le type Date
}
