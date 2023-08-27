package com.example.backendengin.service;

import com.example.backendengin.entities.Famille;
import com.example.backendengin.repositories.DemandeRepo;
import com.example.backendengin.repositories.Famillerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilleService {
    @Autowired
    Famillerepo familleRepository;

    @Autowired
    DemandeRepo demandeRepository;

    public List<Famille>findAll() {
        return familleRepository.findAll();
    }

    public List<Famille> find(Long idDemande) {
        return familleRepository.findByDemandeId(idDemande);
    }
}
