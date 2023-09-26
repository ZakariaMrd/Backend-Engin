package com.example.backendengin.repositories;

import com.example.backendengin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface Utilisateurrepo extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
