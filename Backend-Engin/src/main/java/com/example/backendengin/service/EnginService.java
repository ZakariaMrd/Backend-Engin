package com.example.backendengin.service;

import com.example.backendengin.dtos.EnginDetailsDTO;
import com.example.backendengin.dtos.EnginsortieDTO;
import com.example.backendengin.dtos.FamilleDto;
import com.example.backendengin.entities.Engins;
import com.example.backendengin.entities.Famille;
import com.example.backendengin.repositories.Enginrepo;
import com.example.backendengin.repositories.Famillerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EnginService {
    @Autowired
    Enginrepo enginRepository;

    @Autowired
    Famillerepo familleRepository;

    public String AddEngin(Engins engin){
        Famille famille = familleRepository.findById(engin.getFamille().getIdtype()).orElse(null);
        Engins lengin = enginRepository.save(engin);
        return "engin added successfully";
    }

    public void UpdateFamilleEngin(Long id_engin,Long id_famille){
        Engins engin=enginRepository.findById(id_engin).orElseThrow(()->new RuntimeException("Engin not found"));
        Famille famille = familleRepository.findById(id_famille).orElse(null);
        engin.setFamille(famille);
        enginRepository.save(engin);
    }
    public List<Engins> findAll(){
        return enginRepository.findAll();
    }

    public List<EnginDetailsDTO>getEngineByDemande(long id){
        return enginRepository.getEnginDetailsByDemandeId(id);
    }

    public List<FamilleDto> getQte(long id){
        return enginRepository.getdetail(id);
    }

    public void updateDispoEngin(Long idengin,boolean newdispo) {
        Engins engin = enginRepository.findById(idengin).orElseThrow(() -> new RuntimeException("Engin not found"));
        engin.setDisponibilite(newdispo);
        enginRepository.save(engin);
    }

    public void updatePanneEngin(Long idengin, boolean newpanne) {
        Engins engin = enginRepository.findById(idengin).orElseThrow(() -> new RuntimeException("Engin not found"));
        engin.setPanne(newpanne);
        enginRepository.save(engin);
    }

    public List<EnginsortieDTO>enginSortie(){
        return enginRepository.Enginsortir1();
    }

    public List<Engins>enginAvailable(){
        return enginRepository.findByDisponibiliteIsFalseAndPanneIsFalse();
    }

    public List<EnginsortieDTO>enginentreesDTOS(){
        return enginRepository.Enginentree();
    }

    public void DeleteEngin(Long idengin){
        enginRepository.deleteById(idengin);
    }

    public List<Engins> EnginPanne(){
        return enginRepository.findAllByPanneIsTrue();
    }

}
