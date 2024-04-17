package com.example.demospring.services;

import com.example.demospring.entities.Skieur;
import com.example.demospring.entities.typeAbon;
import com.example.demospring.repositories.SkieurRepository;

import java.time.LocalDate;
import java.util.List;

public interface ISkieurService {
    Skieur addSkieur(Skieur sk);

    Skieur updateSkieur(Skieur sk);

    void removeSkieur(Long idS);

    Skieur retrieveSkieur(Long idS);

    List<Skieur> retrieveAllSkieurs();
    List<Skieur> addListSkieur(List<Skieur> skList);

    List<Skieur> skieurParDate(LocalDate debut, LocalDate fin);

    List<Skieur> retrieveSkieurByAbonnementType(typeAbon typeAbonnement);

    Skieur assignSkieurToPiste(Long numSkieur, Long numPiste);

    Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse);
}
