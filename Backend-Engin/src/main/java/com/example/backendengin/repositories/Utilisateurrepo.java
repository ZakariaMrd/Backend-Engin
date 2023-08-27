package com.example.backendengin.repositories;

import com.example.backendengin.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface Utilisateurrepo extends JpaRepository<Utilisateur,Long> {

}
