package com.example.backendengin.dtos;

import lombok.Data;

@Data

public class EnginsAffectationDTO {
    public long idengin;
    public String nomfamille;
    public String image;
    public EnginsAffectationDTO(long idengin, String nomfamille, String image) {
        this.idengin = idengin;
        this.nomfamille = nomfamille;
        this.image = image;
    }


}
