package com.example.backendengin.service;

import com.example.backendengin.entities.Demande;
import com.example.backendengin.entities.Detaildemmande;
import com.example.backendengin.entities.Famille;
import com.example.backendengin.repositories.DemandeRepo;
import com.example.backendengin.repositories.Detaildemanderepo;
import com.example.backendengin.repositories.Famillerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailDemandeService {
    @Autowired
    Detaildemanderepo detaildemanderepository;
    @Autowired
    DemandeRepo demandeRepository;
    @Autowired
    Famillerepo famillerepository;

    public List<Detaildemmande> findAll(){
        return detaildemanderepository.findAll();
    }

    public void DeleteDetailDemandeById(Long id){
        detaildemanderepository.deleteByDemandeId(id);
    }

    public void AddDetailDemande(List<Detaildemmande> detailDemandes){
        for (Detaildemmande detailDemande : detailDemandes) {
            Demande demande = demandeRepository.findById(detailDemande.getId().getDemandeid()).orElse(null);
            Famille famille = famillerepository.findById(detailDemande.getId().getFamilleid()).orElse(null);
            if (demande != null) {
                detailDemande.setDemande(demande);
            }
            if (famille != null) {
                detailDemande.setFamille(famille);
            }
            detaildemanderepository.save(detailDemande);
        }
    }
}
