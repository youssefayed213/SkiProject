package com.example.demospring.services;

import com.example.demospring.entities.Moniteur;
import com.example.demospring.entities.Support;

import java.util.List;

public interface IMoniteurService {

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, Support support);
}
