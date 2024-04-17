package com.example.demospring.services;

import com.example.demospring.entities.*;
import com.example.demospring.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class SkieurServiceImpl implements ISkieurService{

    SkieurRepository skRep;
    PisteRepository pisRep;
    CoursRepository coursRep;
    InscriptionRepository insRep;
    AbonnementRepository abonnementRepository;

    @Override
    public Skieur addSkieur(Skieur sk) {
        return skRep.save(sk);
    }

    @Override
    public Skieur updateSkieur(Skieur sk) {
        return skRep.save(sk);
    }

    @Override
    public void removeSkieur(Long idS) {
        skRep.deleteById(idS);
    }

    @Override
    public Skieur retrieveSkieur(Long idS) {
        return skRep.findById(idS).orElse(null);
    }

    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skRep.findAll();
    }

    @Override
    public List<Skieur> addListSkieur(List<Skieur> skList) {
        return skRep.saveAll(skList);
          }
    @Override
    public List<Skieur> skieurParDate(LocalDate debut, LocalDate fin){
        return skRep.findByDateNaissanceBetween(debut,fin);

    }

    @Override
    public List<Skieur> retrieveSkieurByAbonnementType(typeAbon typeAbonnement) {
        return skRep.retrieveSkieurByAbonnementType(typeAbonnement);
    }

    @Override
    public Skieur assignSkieurToPiste(Long numSkieur, Long numPiste) {
        Skieur sk = skRep.findById(numSkieur).orElseThrow(() -> new IllegalArgumentException("Skier not found with id: " + numSkieur));
        Piste piste = pisRep.findById(numPiste).orElseThrow(() -> new IllegalArgumentException("Piste not found with id: " + numPiste));

        sk.getPistes().add(piste);
        skRep.save(sk);
        return sk;
    }

    @Override
    public Skieur addSkieurAndAssignToCourse(Skieur skieur, Long numCourse) {

        Cours cours = coursRep.findById(numCourse).orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + numCourse));

        Abonnement abonnement = new Abonnement();
        abonnement = abonnementRepository.save(abonnement);

        skieur.setAbonnement(abonnement);
        Skieur savedSkieur = skRep.save(skieur);

        Inscription inscription = new Inscription();
        inscription.setSkier(savedSkieur);
        inscription.setCours(cours);

        insRep.save(inscription);

        return savedSkieur;
    }


}
