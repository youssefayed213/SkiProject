package com.example.demospring.services;

import com.example.demospring.entities.Abonnement;
import com.example.demospring.entities.typeAbon;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IAbonnementService {

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
    List<Abonnement> findDistinctOrderByDateFinAsc(LocalDate dateExpiration);

    Set<Abonnement> getSubscriptionByType(typeAbon type);
}
