package com.example.demospring.services;

import com.example.demospring.entities.Cours;
import com.example.demospring.entities.Moniteur;
import com.example.demospring.entities.Support;
import com.example.demospring.entities.Inscription;

import com.example.demospring.repositories.CoursRepository;
import com.example.demospring.repositories.MoniteurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IMoniteurServiceImpl implements IMoniteurService{

    MoniteurRepository moniteurRepository;
    CoursRepository coursRepository;
    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + numCourse));
        moniteurRepository.save(moniteur);
        moniteur.getCours().add(cours);
       return moniteurRepository.save(moniteur);

    }

    @Override
    public List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support) {
        Moniteur moniteur = moniteurRepository.findById(numInstructor).orElseThrow(() -> new IllegalArgumentException("Moniteur not found with id: " + numInstructor));

        Set<Cours> coursOfInstructor = moniteur.getCours();


        Set<Cours> filteredCours = coursOfInstructor.stream()
                .filter(c -> c.getSupport() == support)
                .collect(Collectors.toSet());


        Set<Integer> numWeeks = new HashSet<>();
        for (Cours cours : filteredCours) {
            numWeeks.addAll(cours.getInscriptions().stream()
                    .map(Inscription::getNumSemaine)
                    .collect(Collectors.toSet()));
        }

        return numWeeks.stream().sorted().collect(Collectors.toList());
    }
}
