package com.example.demospring.entities;

import com.example.demospring.entities.Color;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Piste")

public class Piste implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdPiste")
    private long numPiste;

    @Column(unique = true,nullable = true)
    private String namePiste;

    @Enumerated(EnumType.STRING)
    private Color c;

    private Integer slope;

    private Integer Length;

    public long getNumPiste() {
        return numPiste;
    }

    public void setNumPiste(long numPiste) {
        this.numPiste = numPiste;
    }

    public String getNamePiste() {
        return namePiste;
    }

    public void setNamePiste(String namePiste) {
        this.namePiste = namePiste;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public Integer getSlope() {
        return slope;
    }

    public void setSlope(Integer slope) {
        this.slope = slope;
    }

    public Integer getLength() {
        return Length;
    }

    public void setLength(Integer length) {
        Length = length;
    }

    public Set<Skieur> getSkiers() {
        return skiers;
    }

    public void setSkiers(Set<Skieur> skiers) {
        this.skiers = skiers;
    }

    @ManyToMany(mappedBy = "pistes")
    private Set<Skieur> skiers;



}
