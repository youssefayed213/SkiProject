package com.example.demospring.controllers;

import com.example.demospring.entities.Abonnement;
import com.example.demospring.entities.Skieur;
import com.example.demospring.entities.typeAbon;
import com.example.demospring.services.IAbonnementService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/abonnements")
public class AbonnementController {
    IAbonnementService abService;

    @GetMapping("/abonnementsByDate/{debut}/{fin}")
    public List<Abonnement> abonnementsByDate(@PathVariable LocalDate debut, @PathVariable LocalDate fin){
        return abService.retrieveSubscriptionsByDates(debut,fin);
    }

    @GetMapping("/abonnementsNonExpired/{dateExp}")
    public List<Abonnement> abonnementsNonExpired(@PathVariable LocalDate dateExp){
        return abService.findDistinctOrderByDateFinAsc(dateExp);
    }

    @GetMapping("/getSubscriptionByType/{typeAbonn}")
    public String getSubscriptionByType(@PathVariable typeAbon typeAbonn){
        Set<Abonnement> abonnements = abService.getSubscriptionByType(typeAbonn);
        StringBuilder messageBuilder = new StringBuilder();

        for (Abonnement abonnement : abonnements) {
            String message = "Num Abonnement : "+abonnement.getNumAbon()+", Type d'Abonnement : " + abonnement.getTypeAbonnement()+", Date début : "+ abonnement.getDateDebut();
            messageBuilder.append(message).append("\n");
        }

        return messageBuilder.toString();
    }
}
