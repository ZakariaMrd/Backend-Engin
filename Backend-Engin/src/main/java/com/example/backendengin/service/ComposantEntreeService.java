package com.example.backendengin.service;

import com.example.backendengin.entities.Composant;
import com.example.backendengin.entities.ComposantEntree;
import com.example.backendengin.entities.Demande;
import com.example.backendengin.entities.Engins;
import com.example.backendengin.repositories.ComposantEntreeRepo;
import com.example.backendengin.repositories.Composantrepo;
import com.example.backendengin.repositories.DemandeRepo;
import com.example.backendengin.repositories.Enginrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComposantEntreeService {
    @Autowired
    Composantrepo composantrepository;
    @Autowired
    Enginrepo enginrepository;
    @Autowired
    DemandeRepo demandeRepository;
    @Autowired
    ComposantEntreeRepo composantentreeRepository;

    public List<ComposantEntree> findAll() {
        return composantentreeRepository.findAll();
    }

    public void AddNewCompasantEntree(List<ComposantEntree> composantEntrees) {
        for (ComposantEntree composantEntree : composantEntrees) {
            Composant compossant = composantrepository.findById(composantEntree.getId().getIdcomposant()).orElse(null);
            Engins engin = enginrepository.findById(composantEntree.getId().getIdengin()).orElse(null);
            Demande demande = demandeRepository.findById(composantEntree.getId().getIddemande()).orElse(null);

            if (compossant != null) {
                composantEntree.setComposant(compossant);
            }
            if (engin != null) {
                composantEntree.setEngin(engin);
            }
            if (demande != null) {
                composantEntree.setDemande(demande);
            }
            composantentreeRepository.save(composantEntree);
        }
    }

    public void DeleteComposantEntree(Long id_engin, Long id_demande) {
        composantentreeRepository.deletebyidengin(id_engin, id_demande);

    }

}




