package com.example.backendengin.service;

import com.example.backendengin.entities.Composant;
import com.example.backendengin.entities.Composantsortie;
import com.example.backendengin.entities.Demande;
import com.example.backendengin.entities.Engins;
import com.example.backendengin.repositories.ComposantSorieRepo;
import com.example.backendengin.repositories.Composantrepo;
import com.example.backendengin.repositories.DemandeRepo;
import com.example.backendengin.repositories.Enginrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposantSortieService {
    @Autowired
    Composantrepo composantrepository;
    @Autowired
    Enginrepo enginrepository;
    @Autowired
    DemandeRepo demanderepository;
    @Autowired
    ComposantSorieRepo composantsortierepository;

    public List<Composantsortie> findAll(){
        return composantsortierepository.findAll();
    }

    public void AddNewComposantSortie(List<Composantsortie> composantsorties){
        for (Composantsortie composantSortie : composantsorties) {
            Composant compossant = composantrepository.findById(composantSortie.getId().getIdcomposant()).orElse(null);
            Engins engin = enginrepository.findById(composantSortie.getId().getIdengin()).orElse(null);
            Demande demande = demanderepository.findById(composantSortie.getId().getIddemande()).orElse(null);
            if (compossant != null) {
                composantSortie.setComposant(compossant);
            }
            if (engin != null) {
                composantSortie.setEngin(engin);
            }
            if (demande != null) {
                composantSortie.setDemande(demande);
            }
            composantsortierepository.save(composantSortie);
        }
    }
    public void DeleteSortie(Long id_engin,Long id_demande) {
        composantsortierepository.deletebyidengin(id_engin,id_demande);
    }
}
