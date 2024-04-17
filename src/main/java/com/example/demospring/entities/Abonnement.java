package com.example.demospring.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Abonnement")
public class Abonnement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numAbon")
    private long numAbon;

    @Column(name = "dateDebut")
    private LocalDate dateDebut;

    @Column(name = "dateFin")
    private LocalDate dateFin;

    @Column(name = "prixAbon")
    private float prixAbon;

    @Enumerated(EnumType.STRING)
    private typeAbon typeAbonnement;

    public Abonnement(long numAbon, LocalDate dateDebut, LocalDate dateFin, float prixAbon, typeAbon typeAbonnement) {
        this.numAbon = numAbon;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prixAbon = prixAbon;
        this.typeAbonnement = typeAbonnement;
    }

    public Abonnement() {
    }

    public long getNumAbon() {
        return numAbon;
    }

    public void setNumAbon(long numAbon) {
        this.numAbon = numAbon;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public float getPrixAbon() {
        return prixAbon;
    }

    public void setPrixAbon(float prixAbon) {
        this.prixAbon = prixAbon;
    }

    public typeAbon getTypeAbonnement() {
        return typeAbonnement;
    }

    public void setTypeAbonnement(typeAbon typeAbonnement) {
        this.typeAbonnement = typeAbonnement;
    }



}
