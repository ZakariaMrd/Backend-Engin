package com.example.backendengin.service;

import com.example.backendengin.entities.Utilisateur;
import com.example.backendengin.repositories.Utilisateurrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    Utilisateurrepo userRepository;

    public List<Utilisateur> findAllUsers(){
        return userRepository.findAll();
    }

    public void DeleteUser(Long id_user){
        userRepository.deleteById(id_user);
    }

    public void AddNewUser(Utilisateur  user){
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bcryptPasswordEncoder.encode(user.getMdp());
        user.setMdp(password);
        userRepository.save(user);
    }

    public void UpdateUserToken(Long id_user, String token){
        Utilisateur user=userRepository.findById(id_user).orElseThrow(()->new RuntimeException("User not found  "));
        user.setToken(token);
        userRepository.save(user);
    }

    public void UpdateUserPassword(String mdp, Long id_user){
        Utilisateur user=userRepository.findById(id_user).orElseThrow(()->new RuntimeException("User not found "));
        user.setMdp(mdp);
        userRepository.save(user);
    }



}
