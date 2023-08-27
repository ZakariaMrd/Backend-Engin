package com.example.backendengin.repositories;

import com.example.backendengin.entities.Detailcommandekey;
import com.example.backendengin.entities.Detaildemmande;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface Detaildemanderepo extends JpaRepository<Detaildemmande, Detailcommandekey> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM \"detail_demande\" WHERE \"id_demande\" = ?1", nativeQuery = true)
    void deleteByDemandeId(Long iddemande);
}
