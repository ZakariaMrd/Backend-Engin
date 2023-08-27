package com.example.backendengin.dtos;

import lombok.Data;

@Data

public class FamilleDto {
    private String nomfamille;
    private  Long quantite;

    public FamilleDto(String nomfamille, Long quantite) {
        this.nomfamille = nomfamille;
        this.quantite = quantite;
    }

}
