package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Composantsortie {
    @EmbeddedId
    private Composantsortiekey id;
    private String remarque;
    @ManyToOne
    @MapsId("idcomposant")
    @JoinColumn(name = "id_composant")
    private Composant composant;
    @ManyToOne
    @MapsId("id_engin")
    @JoinColumn(name = "idengin")
    private Engins engin;
    @ManyToOne
    @MapsId("id_demande")
    @JoinColumn(name = "iddemande")
    private Demande demande;
}
