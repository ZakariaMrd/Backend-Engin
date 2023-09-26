package com.example.backendengin.service;

import com.example.backendengin.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailsService();
    List<User> findAllUsers();

    void DeleteUser(Long id_user);

    void AddNewUser(User user);

    void UpdateUserPassword(String mdp, Long id_user);
}
