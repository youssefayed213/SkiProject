package com.example.demospring.services;

import com.example.demospring.entities.Piste;
import com.example.demospring.entities.Skieur;
import com.example.demospring.repositories.PisteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PisteServiceImpl implements IPisteService{

    PisteRepository pisRep;
    @Override
    public Piste addPiste(Piste piste) {
        return pisRep.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisRep.save(piste);
    }

    @Override
    public void removePiste(Long idP) {
        pisRep.deleteById(idP);
    }

    @Override
    public Piste retrievePiste(Long idP) {
        return pisRep.findById(idP).orElse(null);
    }

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisRep.findAll();
    }
}
