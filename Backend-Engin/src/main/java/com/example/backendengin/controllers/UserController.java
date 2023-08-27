package com.example.backendengin.controllers;

import com.example.backendengin.entities.Utilisateur;
import com.example.backendengin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<Utilisateur> findAllUsers() {
        return userService.findAllUsers();
    }

    @DeleteMapping("/delete/{id_user}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id_user) {
        userService.DeleteUser(id_user);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewUser(@RequestBody Utilisateur user) {
        userService.AddNewUser(user);
        return ResponseEntity.ok("User added successfully");
    }

    @PutMapping("/updateToken/{id_user}")
    public ResponseEntity<String> updateUserToken(
            @PathVariable Long id_user,
            @RequestParam String token) {
        userService.UpdateUserToken(id_user, token);
        return ResponseEntity.ok("User token updated successfully");
    }

    @PutMapping("/updatePassword/{id_user}")
    public ResponseEntity<String> updateUserPassword(
            @PathVariable Long id_user,
            @RequestParam String mdp) {
        userService.UpdateUserPassword(mdp, id_user);
        return ResponseEntity.ok("User password updated successfully");
    }
}
