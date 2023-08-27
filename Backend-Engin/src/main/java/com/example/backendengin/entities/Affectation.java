package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class Affectation implements Serializable {
    @EmbeddedId
    private  Affectation_key id;
    private  Date dateEntree;
    private  Date dateSortie;

    @ManyToOne()
    @MapsId("demandeid")
    @JoinColumn(name="demande_id")
    private Demande demande;

    @ManyToOne()
    @MapsId("enginsid")
    @JoinColumn(name="engins_id")
    private Engins engins;
}
