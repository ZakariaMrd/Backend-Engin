package com.example.backendengin.service;

import com.example.backendengin.entities.Affectation;
import com.example.backendengin.entities.Demande;
import com.example.backendengin.entities.Engins;
import com.example.backendengin.repositories.DemandeRepo;
import com.example.backendengin.repositories.DemandeenginRepo;
import com.example.backendengin.repositories.Enginrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffectationService {
    @Autowired
    DemandeRepo demandeRepo;
    @Autowired
    Enginrepo enginrepo;
    @Autowired
    DemandeenginRepo demandeEnginRepo;

    public List<Affectation> ListeAffectation(){
        return demandeEnginRepo.findAll();
    }

    public void AddNewAffectation(List<Affectation> affectations){
        for (Affectation affectation : affectations) {
            Demande demande = demandeRepo.findById(affectation.getId().getDemandeid()).orElse(null);
            Engins engin = enginrepo.findById(affectation.getId().getEnginsid()).orElse(null);
            if (demande != null) {
                affectation.setDemande(demande);
            }
            if (engin != null) {
                affectation.setEngins(engin);
            }
            demandeEnginRepo.save(affectation);
        }
    }

}
