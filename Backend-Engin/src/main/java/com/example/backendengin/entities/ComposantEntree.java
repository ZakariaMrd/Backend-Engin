package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ComposantEntree {
    @EmbeddedId
    private Composantsortiekey id;
    private String remarque;
    @ManyToOne
    @MapsId("idcomposant")
    @JoinColumn(name = "id_composant")
    private Composant composant;
    @ManyToOne
    @MapsId("id_engin")
    @JoinColumn(name = "id_engin")
    private Engins engin;
    @ManyToOne
    @MapsId("id_demande")
    @JoinColumn(name = "id_demande")
    private Demande demande;


}
