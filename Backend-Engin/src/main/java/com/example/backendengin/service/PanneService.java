package com.example.backendengin.service;

import com.example.backendengin.entities.Composant;
import com.example.backendengin.entities.Composantpanne;
import com.example.backendengin.entities.Engins;
import com.example.backendengin.repositories.Composantpannerepo;
import com.example.backendengin.repositories.Composantrepo;
import com.example.backendengin.repositories.Enginrepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PanneService {
    @Autowired
    Composantrepo composantrepository;
    @Autowired
    Enginrepo enginrepository;
    @Autowired
    Composantpannerepo pannerepository;
    public void saveNewPanne(List<Composantpanne> composantPannes) {
        for(Composantpanne composantPanne : composantPannes) {
            Composant composant=composantrepository.findById(composantPanne.getId().getEnginsid()).orElse(null);
            Engins engin =enginrepository.findById(composantPanne.getId().getEnginsid()).orElse(null);

            if(composant!=null) {
                composantPanne.setComposant(composant);
            }
            if(engin!=null) {
                composantPanne.setEngins(engin);
            }
            pannerepository.save(composantPanne);
        }

    }


    public void UpdatePanneEngin(Long id_engin,Long id_composant,boolean repared) {
        Engins engin=enginrepository.findById(id_engin).orElseThrow(()->new RuntimeException("No such eng"));
        Composant composant=composantrepository.findById(id_composant).orElseThrow(()->new RuntimeException("No such composant"));
        Composantpanne cp= pannerepository.findByEnginsAndComposant(engin,composant).orElseThrow(()->new RuntimeException("Panne composant not found"));
        cp.setRepare(repared);
        pannerepository.save(cp);
    }

    public void DeletePanne(Long id_engin){
        pannerepository.deletebyidengin(id_engin);
    }

}
