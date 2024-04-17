package com.example.demospring.repositories;

import com.example.demospring.entities.Abonnement;
import com.example.demospring.entities.typeAbon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface AbonnementRepository extends JpaRepository<Abonnement,Long> {

    @Query("SELECT abon from Abonnement abon where "
    + "abon.dateDebut >= :startDate "
    + "and abon.dateFin <= :endDate")
    List<Abonnement> retrieveSubscriptionsByDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT abon from Abonnement abon where "
            + "abon.typeAbonnement = :typeAbon ORDER BY abon.dateDebut ASC")
    Set<Abonnement> getSubscriptionByType(@Param("typeAbon")typeAbon type);

    @Query("SELECT DISTINCT abon from Abonnement abon where "
    + "abon.dateFin > :dateExpiration ORDER BY abon.dateFin ASC")
    List<Abonnement> findDistinctOrderByDateFinAsc(@Param("dateExpiration") LocalDate dateExpiration);



}
