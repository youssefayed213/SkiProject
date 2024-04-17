package com.example.demospring.repositories;

import com.example.demospring.entities.Moniteur;
import com.example.demospring.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoniteurRepository extends JpaRepository<Moniteur,Long> {
}
