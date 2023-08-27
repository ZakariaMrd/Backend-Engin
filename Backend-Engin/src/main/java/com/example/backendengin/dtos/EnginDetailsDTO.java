package com.example.backendengin.dtos;

import lombok.Data;

@Data

public class EnginDetailsDTO {
    private Long idengin;
    private Boolean dispo;
    private Long idfamille;
    private String image;
    private String nomfamille;


    public EnginDetailsDTO(Long idengin, Boolean dispo, Long idfamille, String image, String nomfamille) {
        this.idengin = idengin;
        this.dispo = dispo;
        this.idfamille = idfamille;
        this.image = image;
        this.nomfamille = nomfamille;
    }

}
