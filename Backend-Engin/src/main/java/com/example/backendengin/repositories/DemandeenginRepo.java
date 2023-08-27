package com.example.backendengin.repositories;

import com.example.backendengin.entities.Affectation;
import com.example.backendengin.entities.Affectation_key;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface DemandeenginRepo extends JpaRepository<Affectation, Affectation_key> {
    @Modifying
    @Transactional
    @Query("UPDATE Affectation de SET de.dateEntree = CURRENT_DATE WHERE de.id.demandeid = :idDemande AND de.id.enginsid = :idEngin")
    void updateDemandeEnginAffecte(@Param("idDemande") Long idDemande, @Param("idEngin") Long idEngin);

}
