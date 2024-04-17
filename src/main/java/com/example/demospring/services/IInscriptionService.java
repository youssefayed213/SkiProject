package com.example.demospring.services;

import com.example.demospring.entities.Inscription;

public interface IInscriptionService {



    Inscription addRegistrationAndAssignToSkier(Inscription registration, Long numSkier);

    Inscription assignRegistrationToCourse(Long numRegistration, Long numCourse);

    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);


}
