package com.example.demospring.services;

import com.example.demospring.entities.Cours;
import com.example.demospring.entities.Inscription;
import com.example.demospring.entities.Skieur;
import com.example.demospring.repositories.CoursRepository;
import com.example.demospring.repositories.InscriptionRepository;
import com.example.demospring.repositories.SkieurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InscriptionServiceImpl implements IInscriptionService{

    InscriptionRepository insRep;
    CoursRepository coursRep;
    SkieurRepository skRep;


    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier) {
     Skieur sk = skRep.findById(numSkier).orElseThrow(() -> new IllegalArgumentException("Skieur not found with id: " + numSkier));
     registration.setSkier(sk);
    return insRep.save(registration);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse) {
        Inscription inscription = insRep.findById(numRegistration).orElseThrow(() -> new IllegalArgumentException("Inscription not found with id: " + numRegistration));
        Cours cours = coursRep.findById(numCourse).orElseThrow(() -> new IllegalArgumentException("Cours not found with id: " + numCourse));
        inscription.setCours(cours);
        return insRep.save(inscription);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Skieur sk = skRep.findById(numSkieur).orElseThrow(() -> new IllegalArgumentException("Skieur not found with id: " + numSkieur));
        Cours cours = coursRep.findById(numCours).orElseThrow(() -> new IllegalArgumentException("Cours not found with id: " + numCours));
        inscription.setCours(cours);
        inscription.setSkier(sk);
        return insRep.save(inscription);

    }

}
