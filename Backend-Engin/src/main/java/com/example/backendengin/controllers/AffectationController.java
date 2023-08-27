package com.example.backendengin.controllers;

import com.example.backendengin.entities.Affectation;
import com.example.backendengin.service.AffectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/affectations")
public class AffectationController {

    private final AffectationService affectationService;

    @Autowired
    public AffectationController(AffectationService affectationService) {
        this.affectationService = affectationService;
    }

    @GetMapping("/list")
    public List<Affectation> listAffectation() {
        return affectationService.ListeAffectation();
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewAffectation(@RequestBody List<Affectation> affectations) {
        affectationService.AddNewAffectation(affectations);
        return ResponseEntity.ok("Affectations added successfully");
    }
}
