package com.example.backendengin.service.impl;

import com.example.backendengin.entities.User;
import com.example.backendengin.repositories.Utilisateurrepo;
import com.example.backendengin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   private final Utilisateurrepo userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username){
                return userRepository.findByEmail(username)
                        .orElseThrow(()->new UsernameNotFoundException("User not found"));
            }
        };
    }
    @Override
    public List<User> findAllUsers(){
        return userRepository.findAll();
    }
    @Override
     public void DeleteUser(Long id_user){
        userRepository.deleteById(id_user);
    }
    @Override
     public void AddNewUser(User user){
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bcryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }
//    @Override
//     public void UpdateUserToken(Long id_user, String token){
//        User user=userRepository.findById(id_user).orElseThrow(()->new RuntimeException("User not found  "));
//        user.setToken(token);
//        userRepository.save(user);
//    }
    @Override
     public void UpdateUserPassword(String mdp, Long id_user){
        User user=userRepository.findById(id_user).orElseThrow(()->new RuntimeException("User not found "));
        user.setPassword(mdp);
        userRepository.save(user);
    }



}
