package com.example.backendengin.repositories;

import com.example.backendengin.dtos.EnginDetailsDTO;
import com.example.backendengin.dtos.EnginsortieDTO;
import com.example.backendengin.dtos.FamilleDto;
import com.example.backendengin.entities.Engins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Enginrepo extends JpaRepository<Engins,Long> {
    @Query("SELECT new com.example.backendengin.dtos.EnginDetailsDTO(e.idengin, e.disponibilite, e.famille.idtype,f.image,f.nomfammile) FROM Engins e JOIN e.famille f JOIN f.detaildemmandes de WHERE de.id.demandeid = ?1")
    List<EnginDetailsDTO> getEnginDetailsByDemandeId(Long demandeId);
    @Query("SELECT new com.example.backendengin.dtos.FamilleDto(e.nomfammile,de.quantite) FROM Famille e JOIN e.detaildemmandes de  WHERE de.id.demandeid = ?1")
    List<FamilleDto> getdetail(Long demandeId);

    @Query(value = "SELECT  new com.example.backendengin.dtos.EnginsortieDTO(e.idengin,f.nomfammile,f.image,d.iddemande)" +
            "FROM Engins e, Famille f,Affectation de,Demande d\n" +
            "WHERE e.famille.idtype = f.idtype AND e.disponibilite=true and e.panne=false  and \n" +
            "de.id.enginsid=e.idengin and d.iddemande=de.id.demandeid "+
            "  AND FUNCTION('TO_CHAR', d.dateSortie, 'yyyy-MM-dd') = FUNCTION('TO_CHAR', sysdate(), 'yyyy-MM-dd')\n"+
            "and not exists  (select co from ComposantEntree co where co.id.idengin=e.idengin and co.id.iddemande=d.iddemande)"
    )
    List<EnginsortieDTO>Enginsortir1();
    @Query(value = "SELECT  new com.example.backendengin.dtos.EnginsortieDTO(e.idengin,f.nomfammile,f.image,d.iddemande)" +
            "FROM Engins e, Famille f,Affectation de,Demande d\n" +
            "WHERE e.famille.idtype = f.idtype AND e.disponibilite=false and e.panne=false  and \n" +
            "de.id.enginsid=e.idengin and d.iddemande=de.id.demandeid "+
            "  AND FUNCTION('TO_CHAR', d.dateSortie, 'yyyy-MM-dd') = FUNCTION('TO_CHAR', sysdate(), 'yyyy-MM-dd')\n"
    )
    List<EnginsortieDTO>Enginentree();
    List<Engins>findByDisponibiliteIsFalseAndPanneIsFalse();
    List<Engins>findAllByPanneIsTrue();
}
