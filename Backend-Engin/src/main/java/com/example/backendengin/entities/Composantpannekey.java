package com.example.backendengin.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
@Data
@Embeddable
public class Composantpannekey implements Serializable {
    @Column(name="composant_id")
    private Long composantid;
    @Column(name="engins_id")
    private Long enginsid;

}
