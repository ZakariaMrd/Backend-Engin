package com.example.backendengin.controllers;

import com.example.backendengin.entities.ComposantEntree;
import com.example.backendengin.service.ComposantEntreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/composant-entrees")
public class ComposantEnteeController {

    private final ComposantEntreeService composantEntreeService;

    @Autowired
    public ComposantEnteeController(ComposantEntreeService composantEntreeService) {
        this.composantEntreeService = composantEntreeService;
    }

    @GetMapping("/all")
    public List<ComposantEntree> findAllComposantEntree() {
        return composantEntreeService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewComposantEntree(@RequestBody List<ComposantEntree> composantEntrees) {
        composantEntreeService.AddNewCompasantEntree(composantEntrees);
        return ResponseEntity.ok("Composant entrees added successfully");
    }

    @DeleteMapping("/delete/{id_engin}/{id_demande}")
    public ResponseEntity<String> deleteComposantEntree(
            @PathVariable Long id_engin,
            @PathVariable Long id_demande) {
        composantEntreeService.DeleteComposantEntree(id_engin, id_demande);
        return ResponseEntity.ok("Composant entree deleted successfully");
    }
}
