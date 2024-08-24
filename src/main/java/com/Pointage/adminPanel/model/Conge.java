package com.Pointage.adminPanel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "conge")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employe_id", nullable = false)
    private Employe employe;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateFin;

    @Column(nullable = false)
    private String type;
}
