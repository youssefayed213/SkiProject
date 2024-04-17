package com.example.demospring.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Inscription")
public class Inscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdInscri")
    private long numInscription;



    @Column(name = "numSemaine")
    private int numSemaine;

    public Inscription(long numInscription, int numSemaine) {
        this.numInscription = numInscription;
        this.numSemaine = numSemaine;
    }

    public Inscription() {
    }

    public long getNumInscription() {
        return numInscription;
    }

    public void setNumInscription(long numInscription) {
        this.numInscription = numInscription;
    }

    public int getNumSemaine() {
        return numSemaine;
    }

    public void setNumSemaine(int numSemaine) {
        this.numSemaine = numSemaine;
    }

    public Skieur getSkier() {
        return skier;
    }

    public void setSkier(Skieur skier) {
        this.skier = skier;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    @ManyToOne
    private Skieur skier;

    @ManyToOne
    private Cours cours;

}
