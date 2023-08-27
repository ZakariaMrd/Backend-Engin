package com.example.backendengin.service;

import com.example.backendengin.dtos.EnginsAffectationDTO;
import com.example.backendengin.entities.Demande;
import com.example.backendengin.entities.Utilisateur;
import com.example.backendengin.repositories.DemandeRepo;
import com.example.backendengin.repositories.Utilisateurrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DemandeService {
    @Autowired
    DemandeRepo demandeRepository;

    @Autowired
    Utilisateurrepo userRepository;

    public Demande addDemande(Demande demande){
        Demande Newdemande = demandeRepository.save(demande);
        return Newdemande;
    }

    public void UpdateDemande(Demande demande){
        Optional<Demande> demandeExistante =demandeRepository.findById(demande.getIddemande());
        if(demandeExistante.isPresent()) {
            Demande demandeUpdate =demandeExistante.get();
            if (demande.getDateSortie() != null) {
                demandeUpdate.setDateSortie(demande.getDateSortie());
            }
            if (demande.getRaison() != null) {
                demandeUpdate.setRaison(demande.getRaison());
            }
            if (demande.getShift() != null) {
                demandeUpdate.setShift(demande.getShift());
            }
            if (demande.getConfirmation() != null) {
                demandeUpdate.setConfirmation(demande.getConfirmation());
            }
            Demande demandeMiseAJour = demandeRepository.save(demandeUpdate);
        } else {
            throw new RuntimeException("Demande non trouvée : " + demande.getIddemande());

        }
    }

    public List<Demande> getDemandes(){
        return demandeRepository.findAll();
    }
    public List<Demande>getDemandeById(Long idDemande){
        return demandeRepository.findByIddemande(idDemande);
    }

    public List<Demande> getDemandeByUserId(Long id_user) {
        Utilisateur user = new Utilisateur();
        user.setId_user(id_user);
        return demandeRepository.findByUser(user);
    }

    public void deleteDemande(Long id_demande) {
        demandeRepository.deleteById(id_demande);
    }

    public List<EnginsAffectationDTO> findByDate(String date, Long id_demande) {
        return demandeRepository.findEnginDispoByDemandeAndDate(date,id_demande);
    }

    public List<Demande>findNonTraiter(){
        return demandeRepository.findByConfirmationIsFalse();
    }

    public List<Demande>findBySortie(Long id_engin){
        return demandeRepository.finddemandeenginsotrie(id_engin);
    }

    public void updateDemandeConfirmation(Long id_demande,boolean newConfirmation){
        Demande demande=demandeRepository.findById(id_demande).orElseThrow(() -> new RuntimeException("Demande not found"));
        demande.setConfirmation(newConfirmation);
        demandeRepository.save(demande);
    }

}
