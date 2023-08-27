package com.example.backendengin.controllers;

import com.example.backendengin.entities.Famille;
import com.example.backendengin.service.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/familles")
public class FamilleController {

    private final FamilleService familleService;

    @Autowired
    public FamilleController(FamilleService familleService) {
        this.familleService = familleService;
    }

    @GetMapping("/all")
    public List<Famille> getAllFamilles() {
        return familleService.findAll();
    }

    @GetMapping("/demande/{idDemande}")
    public List<Famille> getFamillesByDemandeId(@PathVariable Long idDemande) {
        return familleService.find(idDemande);
    }
}
