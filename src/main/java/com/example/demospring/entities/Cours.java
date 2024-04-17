package com.example.demospring.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Cours")
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numCours")
    private long numCours;

    @Column(name = "niveau")
    private int niveau;

    @Enumerated(EnumType.STRING)
    private TypeCours TypeCours;

    @Enumerated(EnumType.STRING)
    private Support Support;

    @Column(name = "prix")
    private float prix;

    @Column(name = "crenau")
    private int crenau;

    public Cours(long numCours, int niveau, com.example.demospring.entities.TypeCours typeCours, com.example.demospring.entities.Support support, float prix, int crenau) {
        this.numCours = numCours;
        this.niveau = niveau;
        TypeCours = typeCours;
        Support = support;
        this.prix = prix;
        this.crenau = crenau;
    }

    public Cours() {
    }

    public long getNumCours() {
        return numCours;
    }

    public void setNumCours(long numCours) {
        this.numCours = numCours;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public com.example.demospring.entities.TypeCours getTypeCours() {
        return TypeCours;
    }

    public void setTypeCours(com.example.demospring.entities.TypeCours typeCours) {
        TypeCours = typeCours;
    }

    public com.example.demospring.entities.Support getSupport() {
        return Support;
    }

    public void setSupport(com.example.demospring.entities.Support support) {
        Support = support;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getCrenau() {
        return crenau;
    }

    public void setCrenau(int crenau) {
        this.crenau = crenau;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    @OneToMany(mappedBy = "cours",cascade = CascadeType.ALL)
    private Set<Inscription> inscriptions;

}
