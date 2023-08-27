package com.example.backendengin.controllers;

import com.example.backendengin.entities.Composantsortie;
import com.example.backendengin.service.ComposantSortieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composant-sorties")
public class ComposantSortieController {

    private final ComposantSortieService composantSortieService;

    @Autowired
    public ComposantSortieController(ComposantSortieService composantSortieService) {
        this.composantSortieService = composantSortieService;
    }

    @GetMapping("/all")
    public List<Composantsortie> findAllComposantSortie() {
        return composantSortieService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewComposantSortie(@RequestBody List<Composantsortie> composantSorties) {
        composantSortieService.AddNewComposantSortie(composantSorties);
        return ResponseEntity.ok("Composant sorties added successfully");
    }

    @DeleteMapping("/delete/{id_engin}/{id_demande}")
    public ResponseEntity<String> deleteComposantSortie(
            @PathVariable Long id_engin,
            @PathVariable Long id_demande) {
        composantSortieService.DeleteSortie(id_engin, id_demande);
        return ResponseEntity.ok("Composant sorties deleted successfully");
    }
}
