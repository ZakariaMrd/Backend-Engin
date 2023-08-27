package com.example.backendengin.repositories;

import com.example.backendengin.entities.Composant;
import com.example.backendengin.entities.Composantpanne;
import com.example.backendengin.entities.Composantpannekey;
import com.example.backendengin.entities.Engins;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface Composantpannerepo extends JpaRepository<Composantpanne, Composantpannekey> {

    Optional<Composantpanne> findByEnginsAndComposant(Engins engins, Composant composant);

    @Modifying
    @Transactional
    @Query(value = "delete from Composantpanne c where c.id.enginsid=:idengin ")
    void deletebyidengin(@Param("idengin") Long idengin);
}
