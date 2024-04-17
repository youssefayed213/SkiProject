package com.example.demospring.services;

import com.example.demospring.entities.Piste;
import com.example.demospring.entities.Skieur;

import java.util.List;

public interface IPisteService {

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    void removePiste(Long idP);

    Piste retrievePiste(Long idP);

    List<Piste> retrieveAllPistes();
}
