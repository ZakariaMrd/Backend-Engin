package com.example.backendengin.controllers;

import com.example.backendengin.dtos.EnginDetailsDTO;
import com.example.backendengin.dtos.EnginsortieDTO;
import com.example.backendengin.dtos.FamilleDto;
import com.example.backendengin.entities.Engins;
import com.example.backendengin.service.EnginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engins")
public class EnginController {

    private final EnginService enginService;

    @Autowired
    public EnginController(EnginService enginService) {
        this.enginService = enginService;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEngin(@RequestBody Engins engin) {
        String result = enginService.AddEngin(engin);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/updateFamille/{idEngin}/{idFamille}")
    public ResponseEntity<String> updateFamilleEngin(
            @PathVariable Long idEngin,
            @PathVariable Long idFamille) {
        enginService.UpdateFamilleEngin(idEngin, idFamille);
        return ResponseEntity.ok("Famille updated successfully");
    }

    @GetMapping("/all")
    public List<Engins> getAllEngins() {
        return enginService.findAll();
    }

    @GetMapping("/byDemande/{id}")
    public List<EnginDetailsDTO> getEnginByDemande(@PathVariable Long id) {
        return enginService.getEngineByDemande(id);
    }

    @GetMapping("/qte/{id}")
    public List<FamilleDto> getQte(@PathVariable Long id) {
        return enginService.getQte(id);
    }

    @PutMapping("/updateDispo/{idEngin}/{newDispo}")
    public ResponseEntity<String> updateDispoEngin(
            @PathVariable Long idEngin,
            @PathVariable boolean newDispo) {
        enginService.updateDispoEngin(idEngin, newDispo);
        return ResponseEntity.ok("Disponibilite updated successfully");
    }

    @PutMapping("/updatePanne/{idEngin}/{newPanne}")
    public ResponseEntity<String> updatePanneEngin(
            @PathVariable Long idEngin,
            @PathVariable boolean newPanne) {
        enginService.updatePanneEngin(idEngin, newPanne);
        return ResponseEntity.ok("Panne updated successfully");
    }

    @GetMapping("/sortie")
    public List<EnginsortieDTO> getEnginSortie() {
        return enginService.enginSortie();
    }

    @GetMapping("/available")
    public List<Engins> getEnginAvailable() {
        return enginService.enginAvailable();
    }

    @GetMapping("/entrees")
    public List<EnginsortieDTO> getEnginEntrees() {
        return enginService.enginentreesDTOS();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEngin(@PathVariable Long id) {
        enginService.DeleteEngin(id);
        return ResponseEntity.ok("Engin deleted successfully");
    }

    @GetMapping("/panne")
    public List<Engins> getEnginPanne() {
        return enginService.EnginPanne();
    }
}
