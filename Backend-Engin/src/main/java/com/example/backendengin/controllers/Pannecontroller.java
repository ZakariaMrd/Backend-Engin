package com.example.backendengin.controllers;

import com.example.backendengin.entities.Composantpanne;
import com.example.backendengin.service.PanneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pannes")
public class Pannecontroller {

    private final PanneService panneService;

    @Autowired
    public Pannecontroller(PanneService panneService) {
        this.panneService = panneService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> saveNewPanne(@RequestBody List<Composantpanne> composantPannes) {
        panneService.saveNewPanne(composantPannes);
        return ResponseEntity.ok("Pannes saved successfully");
    }

    @PutMapping("/update/{id_engin}/{id_composant}/{repared}")
    public ResponseEntity<String> updatePanneEngin(
            @PathVariable Long id_engin,
            @PathVariable Long id_composant,
            @PathVariable boolean repared) {
        panneService.UpdatePanneEngin(id_engin, id_composant, repared);
        return ResponseEntity.ok("Panne updated successfully");
    }

    @DeleteMapping("/delete/{id_engin}")
    public ResponseEntity<String> deletePanne(@PathVariable Long id_engin) {
        panneService.DeletePanne(id_engin);
        return ResponseEntity.ok("Panne deleted successfully");
    }
}
