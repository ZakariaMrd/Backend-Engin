package com.example.backendengin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Embeddable
@Data

public class Affectation_key implements Serializable {

    @Column(name="demande_id")
    private Long demandeid;
    @Column(name="engins_id")
    private Long enginsid;
}
