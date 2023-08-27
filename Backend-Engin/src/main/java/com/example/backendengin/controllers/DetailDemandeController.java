package com.example.backendengin.controllers;

import com.example.backendengin.entities.Detaildemmande;
import com.example.backendengin.service.DetailDemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detail-demandes")
public class DetailDemandeController {

    private final DetailDemandeService detailDemandeService;

    @Autowired
    public DetailDemandeController(DetailDemandeService detailDemandeService) {
        this.detailDemandeService = detailDemandeService;
    }

    @GetMapping("/all")
    public List<Detaildemmande> findAllDetailDemande() {
        return detailDemandeService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetailDemande(@PathVariable Long id) {
        detailDemandeService.DeleteDetailDemandeById(id);
        return ResponseEntity.ok("Detail demande deleted successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDetailDemande(@RequestBody List<Detaildemmande> detailDemandes) {
        detailDemandeService.AddDetailDemande(detailDemandes);
        return ResponseEntity.ok("Detail demandes added successfully");
    }
}
