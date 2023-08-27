package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data

@Entity
public class Composantpanne implements Serializable {
    @EmbeddedId
    private Composantpannekey id;
    private String remarque;

    private boolean repare;
    @ManyToOne()
    @MapsId("composantid")
    @JoinColumn(name="composant_id")
    private Composant composant;

    @ManyToOne()
    @MapsId("enginsid")
    @JoinColumn(name="engins_id")
    private Engins engins;
}


