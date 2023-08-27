package com.example.backendengin.repositories;

import com.example.backendengin.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Famillerepo extends JpaRepository<Famille,Long> {
    @Query( "SELECT DISTINCT f FROM Famille f " +
            "JOIN f.detaildemmandes d " +
            "JOIN d.demande de " +
            "WHERE de.iddemande = :iddemande")
    List<Famille> findByDemandeId(@Param("iddemande") Long iddemande);
}
