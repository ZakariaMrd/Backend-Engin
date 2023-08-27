package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Demande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iddemande;
    private Date dateSortie;
    private Boolean confirmation;
    private String Shift;
    private String Raison;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private Utilisateur user;
    @OneToMany(mappedBy = "demande",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Detaildemmande> detaildemmandes;
    @OneToMany(mappedBy = "demande",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Affectation> deatailengins;
    @OneToMany(mappedBy = "demande",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Composantsortie> composantSorties;
    @OneToMany(mappedBy = "demande",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ComposantEntree> composantEntrees;

}
