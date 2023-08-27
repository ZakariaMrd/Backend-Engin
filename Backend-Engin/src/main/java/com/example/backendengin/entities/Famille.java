package com.example.backendengin.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data


public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtype;
    private String nomfammile;
    private String image;
    @OneToMany(mappedBy = "famille",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Engins> engins;
 @OneToMany(mappedBy = "famille",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Detaildemmande> detaildemmandes;

}
