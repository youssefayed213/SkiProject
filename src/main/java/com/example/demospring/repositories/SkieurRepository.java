package com.example.demospring.repositories;

import com.example.demospring.entities.Inscription;
import com.example.demospring.entities.Skieur;
import com.example.demospring.entities.TypeCours;
import com.example.demospring.entities.typeAbon;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Repository
public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    List<Skieur> findByDateNaissanceBetween(LocalDate debut, LocalDate fin);
    //List<Skieur> findByInscriptionsCoursTypeCours(TypeCours cours);

    @Query("SELECT s FROM Skieur s, Abonnement abo where "
    + "abo.numAbon = s.abonnement.numAbon "
    + "and abo.typeAbonnement =:typeAbonn "
    )
    List<Skieur> retrieveSkieurByAbonnementType(@Param("typeAbonn") typeAbon typeAbonn);
}
