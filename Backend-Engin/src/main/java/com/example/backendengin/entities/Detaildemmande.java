package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Entity
@Data
public class Detaildemmande implements Serializable {
    @EmbeddedId
    private  Detailcommandekey id;
    private Long quantite;
    @ManyToOne()
    @MapsId("demandeid")
    @JoinColumn(name="demande_id")
    private Demande demande;
    @ManyToOne()
    @MapsId("familleid")
    @JoinColumn(name="famille_id")
    private Famille famille;



}
