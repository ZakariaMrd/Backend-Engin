package com.example.backendengin.repositories;

import com.example.backendengin.dtos.EnginsAffectationDTO;
import com.example.backendengin.entities.Demande;
import com.example.backendengin.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface DemandeRepo extends JpaRepository<Demande,Long> {
    List<Demande> findByUser(Utilisateur user);

    List<Demande> findByIddemande(Long id);
    List<Demande> findByConfirmationIsFalse();
    @Query("select new com.example.backendengin.dtos.EnginsAffectationDTO(e.idengin,f.nomfammile,f.image) from Engins e, Famille f, Detaildemmande d where e.famille.idtype = f.idtype and f.idtype = d.famille.idtype and d.demande.iddemande = :iddemande and e.disponibilite = true and e.panne = false and e.idengin not in (select aff.engins.idengin from Affectation aff, Demande de where de.iddemande = aff.demande.iddemande and To_char(de.dateSortie,'yyyy-MM-dd')=:dateSortie)")
    List<EnginsAffectationDTO> findEnginDispoByDemandeAndDate(@Param("dateSortie") String dateSortie, @Param("iddemande") Long iddemande);
    @Query("SELECT de FROM Demande de, Affectation ef \n" +
            "WHERE de.iddemande = ef.id.demandeid \n" +
            "AND FUNCTION('to_char', de.dateSortie, 'yyyy-mm-dd') =FUNCTION('to_char', current_date,'yyyy-mm-dd') \n" +
            "AND ef.id.enginsid = :idengin")
    List<Demande> finddemandeenginsotrie(@Param("idengin") Long idengin);
}
