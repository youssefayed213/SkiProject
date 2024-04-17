package com.example.demospring.controllers;

import com.example.demospring.entities.Inscription;
import com.example.demospring.services.IInscriptionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/inscriptions")
public class InscriptionController {

    IInscriptionService insService;


    @PostMapping("/addRegistrationAndAssignToSkier/{numSkier}")
    public String addRegistrationAndAssignToSkier(@RequestBody Inscription inscription, @PathVariable Long numSkier){
        Inscription ins =insService.addRegistrationAndAssignToSkier(inscription,numSkier);
        return ("Registration added successfully to skier: "+ins.getSkier().getNumSkieur());
    }

    @PutMapping("/assignRegistrationToCourse")
    public String  assignRegistrationToCourse(@RequestParam Long numRegistration, @RequestParam Long numCourse){
        Inscription ins =insService.assignRegistrationToCourse(numRegistration,numCourse);
        return ("Registration: "+ins.getNumInscription()+", assigned successfully to course: "+ins.getCours().getNumCours());
    }

    @PostMapping("/addRegistrationAndAssignToSkierAndCourse/{numSkier}/{numCours}")
    public String addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription, @PathVariable Long numSkier, @PathVariable Long numCours){
        Inscription ins =insService.addRegistrationAndAssignToSkierAndCourse(inscription,numSkier,numCours);
        return ("Registration added successfully to skier: "+ins.getSkier().getNumSkieur()+" , and course: "+ins.getCours().getNumCours());
    }

}
