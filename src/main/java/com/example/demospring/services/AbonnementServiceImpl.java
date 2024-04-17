package com.example.demospring.services;

import com.example.demospring.entities.Abonnement;
import com.example.demospring.entities.typeAbon;
import com.example.demospring.repositories.AbonnementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AbonnementServiceImpl implements IAbonnementService{

    AbonnementRepository abRep;
    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abRep.retrieveSubscriptionsByDates(startDate,endDate);
    }

    @Override
    public List<Abonnement> findDistinctOrderByDateFinAsc(LocalDate dateExpiration) {
        return abRep.findDistinctOrderByDateFinAsc(dateExpiration);
    }

    @Override
    public Set<Abonnement> getSubscriptionByType(typeAbon type) {
        return abRep.getSubscriptionByType(type);
    }
}
