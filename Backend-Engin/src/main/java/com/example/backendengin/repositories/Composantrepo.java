package com.example.backendengin.repositories;

import com.example.backendengin.entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface Composantrepo extends JpaRepository<Composant,Long> {

    List<Composant> findByComposantSortiesDemandeIddemandeAndComposantSortiesEnginIdengin(Long iddemande, Long idengin);
    List<Composant> findByComposantEntreesDemandeIddemandeAndComposantEntreesEnginIdengin(Long iddemande, Long idengin);
    List<Composant> findByComposantpannesEngins(Long engins);



}
