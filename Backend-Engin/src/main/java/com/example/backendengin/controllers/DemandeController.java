package com.example.backendengin.controllers;

import com.example.backendengin.dtos.EnginsAffectationDTO;
import com.example.backendengin.entities.Demande;
import com.example.backendengin.service.DemandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demandes")
public class DemandeController {

    private final DemandeService demandeService;

    @Autowired
    public DemandeController(DemandeService demandeService) {
        this.demandeService = demandeService;
    }

    @PostMapping("/add")
    public ResponseEntity<Demande> addDemande(@RequestBody Demande demande) {
        Demande newDemande = demandeService.addDemande(demande);
        return ResponseEntity.ok(newDemande);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateDemande(@RequestBody Demande demande) {
        demandeService.UpdateDemande(demande);
        return ResponseEntity.ok("Demande updated successfully");
    }

    @GetMapping("/all")
    public List<Demande> getAllDemandes() {
        return demandeService.getDemandes();
    }

    @GetMapping("/{idDemande}")
    public List<Demande> getDemandeById(@PathVariable Long idDemande) {
        return demandeService.getDemandeById(idDemande);
    }

    @GetMapping("/byUser/{id_user}")
    public List<Demande> getDemandeByUserId(@PathVariable Long id_user) {
        return demandeService.getDemandeByUserId(id_user);
    }

    @DeleteMapping("/delete/{id_demande}")
    public ResponseEntity<String> deleteDemande(@PathVariable Long id_demande) {
        demandeService.deleteDemande(id_demande);
        return ResponseEntity.ok("Demande deleted successfully");
    }

    @GetMapping("/findByDate")
    public List<EnginsAffectationDTO> findByDate(
            @RequestParam String date,
            @RequestParam Long id_demande) {
        return demandeService.findByDate(date, id_demande);
    }

    @GetMapping("/nonTraiter")
    public List<Demande> findNonTraiter() {
        return demandeService.findNonTraiter();
    }

    @GetMapping("/findBySortie/{id_engin}")
    public List<Demande> findBySortie(@PathVariable Long id_engin) {
        return demandeService.findBySortie(id_engin);
    }

    @PutMapping("/updateConfirmation/{id_demande}/{newConfirmation}")
    public ResponseEntity<String> updateDemandeConfirmation(
            @PathVariable Long id_demande,
            @PathVariable boolean newConfirmation) {
        demandeService.updateDemandeConfirmation(id_demande, newConfirmation);
        return ResponseEntity.ok("Confirmation updated successfully");
    }
}
