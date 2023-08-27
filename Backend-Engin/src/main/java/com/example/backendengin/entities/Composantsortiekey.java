package com.example.backendengin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data

public class Composantsortiekey implements Serializable{
    @Column(name = "id_composant")
    private Long idcomposant;
    @Column(name="id_demande")
    private Long iddemande;
    @Column(name="id_engin")
    private Long idengin;
}
