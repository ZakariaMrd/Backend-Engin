package com.example.backendengin.repositories;

import com.example.demo.entities.Composant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Composantrepo extends JpaRepository<Composant,Long> {
}
