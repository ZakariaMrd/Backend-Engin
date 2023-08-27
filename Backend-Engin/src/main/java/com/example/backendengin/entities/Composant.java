package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Composant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idcomposant;
    private String nom;
    private String image;
    @OneToMany(mappedBy = "composant",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Composantpanne> composantpannes;
    @OneToMany(mappedBy = "composant",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Composantsortie> composantSorties;
    @OneToMany(mappedBy = "composant",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ComposantEntree> composantEntrees;
}
