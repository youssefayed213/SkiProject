package com.example.demospring.controllers;

import com.example.demospring.entities.Moniteur;
import com.example.demospring.entities.Support;

import com.example.demospring.entities.Skieur;
import com.example.demospring.services.IMoniteurService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/moniteurs")
public class MoniteurController {

    IMoniteurService moniteurService;

    @PostMapping("/addInstructorAndAssignToCourse/{numCourse}")
    public String addInstructorAndAssignToCourse(@RequestBody Moniteur moniteur, @PathVariable Long numCourse) {

        Moniteur moniteuur = moniteurService.addInstructorAndAssignToCourse(moniteur,numCourse);
        return ("Moniteur: "+moniteuur.getNumMoniteur()+", assigned successfully to course: "+numCourse);

    }

    @GetMapping("numWeeksCourseOfInstructorBySupport/{numInstructor}/{support}")
    public List<Integer> numWeeksCourseOfInstructorBySupport(@PathVariable("numInstructor") Long numInstructor, @PathVariable("support") Support support) {
        return moniteurService.numWeeksCourseOfInstructorBySupport(numInstructor, support);
    }

}
