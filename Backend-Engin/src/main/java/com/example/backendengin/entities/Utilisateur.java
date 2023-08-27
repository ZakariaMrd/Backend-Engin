package com.example.backendengin.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_user;
    private String login;
    private String mdp;
    private String type;
    private String email;
    private String token;
    @OneToMany(mappedBy = "user",targetEntity = Demande.class,cascade = CascadeType.ALL)
    private List<Demande> demandes;
}
