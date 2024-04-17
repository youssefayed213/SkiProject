package com.example.demospring.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Moniteur")
public class Moniteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numMoniteur")
    private long numMoniteur;

    @Column(name = "nomM")
    private String nomM;

    @Column(name = "prennomM")
    private String prennomM;

    @Column(name = "dateRecru")
    private Date dateRecru;

    public Moniteur(long numMoniteur, String nomM, String prennomM, Date dateRecru) {
        this.numMoniteur = numMoniteur;
        this.nomM = nomM;
        this.prennomM = prennomM;
        this.dateRecru = dateRecru;
    }

    public Moniteur() {
    }

    public long getNumMoniteur() {
        return numMoniteur;
    }

    public void setNumMoniteur(long numMoniteur) {
        this.numMoniteur = numMoniteur;
    }

    public String getNomM() {
        return nomM;
    }

    public void setNomM(String nomM) {
        this.nomM = nomM;
    }

    public String getPrennomM() {
        return prennomM;
    }

    public void setPrennomM(String prennomM) {
        this.prennomM = prennomM;
    }

    public Date getDateRecru() {
        return dateRecru;
    }

    public void setDateRecru(Date dateRecru) {
        this.dateRecru = dateRecru;
    }

    public Set<Cours> getCours() {
        return cours;
    }

    public void setCours(Set<Cours> cours) {
        this.cours = cours;
    }

    @OneToMany
    private Set<Cours> cours= new HashSet<>();;
}
