package com.example.backendengin.controllers;

import com.example.backendengin.entities.Composant;
import com.example.backendengin.service.ComposantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composants")
public class ComposantController {

    private final ComposantService composantService;

    @Autowired
    public ComposantController(ComposantService composantService) {
        this.composantService = composantService;
    }

    @GetMapping("/all")
    public List<Composant> getAllComposants() {
        return composantService.getAll();
    }

    @GetMapping("/sortie/{id_demande}/{id_engin}")
    public List<Composant> getComposantSortieByIdDemandeAndIdEngin(
            @PathVariable("id_demande") Long id_demande,
            @PathVariable("id_engin") Long id_engin) {
        return composantService.getComposantSortieByIdDemandeAndIdEngin(id_demande, id_engin);
    }

    @GetMapping("/entree/{id_demande}/{id_engin}")
    public List<Composant> getComposantEntreeByIdDemandeAndIdEngin(
            @PathVariable("id_demande") Long id_demande,
            @PathVariable("id_engin") Long id_engin) {
        return composantService.getComposantEntreeByIdDemandeAndIdEngin(id_demande, id_engin);
    }

    @GetMapping("/panne/{idengin}")
    public List<Composant> getComposantPanneByIdEngin(@PathVariable("idengin") Long idengin) {
        return composantService.getComposantPanneByIdEngin(idengin);
    }
}
