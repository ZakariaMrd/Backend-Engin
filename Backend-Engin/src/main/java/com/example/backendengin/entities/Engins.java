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

public class Engins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idengin;
    private Boolean panne;
    private   Boolean disponibilite;
    @ManyToOne
    @JoinColumn(name = "idfamille")
    private Famille famille;
    @OneToMany(mappedBy = "engins",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Affectation> deatailengins;
    @OneToMany(mappedBy = "engins",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Composantpanne> composantpannes;
    @OneToMany(mappedBy = "engin",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Composantsortie> composantSorties;
    @OneToMany(mappedBy = "engin",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ComposantEntree> composantEntrees;



}
