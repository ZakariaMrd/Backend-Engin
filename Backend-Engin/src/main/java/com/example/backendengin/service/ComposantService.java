package com.example.backendengin.service;

import com.example.backendengin.entities.Composant;
import com.example.backendengin.repositories.Composantrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ComposantService {
    @Autowired
    Composantrepo composantrepository;
    public List<Composant>getAll(){
        return composantrepository.findAll();
    }
    public List<Composant>getComposantSortieByIdDemandeAndIdEngin(Long id_demande,Long id_engin){
        return composantrepository.findByComposantSortiesDemandeIddemandeAndComposantSortiesEnginIdengin(id_demande,id_engin);
    }

    public List<Composant>getComposantEntreeByIdDemandeAndIdEngin(Long id_demande,Long id_engin){
        return composantrepository.findByComposantEntreesDemandeIddemandeAndComposantEntreesEnginIdengin(id_demande,id_engin);
    }

    public List<Composant>getComposantPanneByIdEngin(Long idengin){
        return composantrepository.findByComposantpannesEngins(idengin);
    }
}
