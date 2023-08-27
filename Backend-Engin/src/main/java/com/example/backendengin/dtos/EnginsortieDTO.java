package com.example.backendengin.dtos;

import lombok.Data;

@Data

public class EnginsortieDTO {
    public long idengin;
    public String nomfamille;
    public String image;
    public long iddemande;

    public EnginsortieDTO(long idengin, String nomfamille, String image, long iddemande) {
        this.idengin = idengin;
        this.nomfamille = nomfamille;
        this.image = image;
        this.iddemande = iddemande;
    }

}
