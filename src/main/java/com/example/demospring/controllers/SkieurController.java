package com.example.demospring.controllers;

import com.example.demospring.entities.Inscription;
import com.example.demospring.entities.Skieur;
import com.example.demospring.entities.typeAbon;
import com.example.demospring.services.IAbonnementService;
import com.example.demospring.services.IPisteService;
import com.example.demospring.services.ISkieurService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/skieurs")
public class SkieurController {
    ISkieurService skService;

    @GetMapping("/getAllSkieurs")
    public List<Skieur> getAllSkieurs(){
        List<Skieur> listSkieurs = (List<Skieur>)skService.retrieveAllSkieurs();
        return listSkieurs;
    }
    @PostMapping("/addskieur")
    public Skieur addSkieur(@RequestBody Skieur skieur){
        return skService.addSkieur(skieur);
    }

    @PutMapping("/updateskieur")
    public Skieur updateSkieur(@RequestBody Skieur skieur){
        return skService.updateSkieur(skieur);
    }

    @DeleteMapping("deleteskieur/{id-skieur}")
    public void removeskieur(@PathVariable ("id-skieur") Long idskieur){
        skService.removeSkieur(idskieur);
    }

    @PostMapping("/addListSkieurs")
    public List<Skieur> addListSkieur(@RequestBody List<Skieur> skList){
        return skService.addListSkieur(skList);
    }

    @GetMapping("/skieursByDate/{debut}/{fin}")
    public List<Skieur> skieursByDate(@PathVariable LocalDate debut, @PathVariable LocalDate fin){
        return skService.skieurParDate(debut,fin);
    }

    @GetMapping("/skieursByTypeAbonn/{typeAbonn}")
    public String skieursBytypeAbon(@PathVariable typeAbon typeAbonn){
        List<Skieur> skieurs = skService.retrieveSkieurByAbonnementType(typeAbonn);
        StringBuilder messageBuilder = new StringBuilder();

        for (Skieur skieur : skieurs) {
            String message = "Num skier : "+skieur.getNumSkieur()+", Type d'Abonnement : " + skieur.getAbonnement().getTypeAbonnement();
            messageBuilder.append(message).append("\n");
        }

        return messageBuilder.toString();
    }

    @PutMapping("/assignSkieurToPiste/{numSkieur}/{numPiste}")
    public String assignSkieurToPiste(@PathVariable Long numSkieur, @PathVariable Long numPiste){
        Skieur skier = skService.assignSkieurToPiste(numSkieur,numPiste);
        return ("Skier: "+skier.getNumSkieur()+", assigned successfully to piste: "+numPiste);
    }

    @PostMapping("/addSkieurAndAssignToCourse/{numCourse}")
    public String addSkieurAndAssignToCourse(@RequestBody Skieur skieur,@PathVariable Long numCourse) {
        Skieur skieur1 = skService.addSkieurAndAssignToCourse(skieur,numCourse);
        return ("Skier: "+skieur1.getNumSkieur()+", assigned successfully to course: "+numCourse);

    }

}
