package com.example.backendengin.controllers;

import com.example.backendengin.entities.User;
import com.example.backendengin.service.UserService;
import com.example.backendengin.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {

    private final UserService userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userServiceImpl.findAllUsers();
    }

    @DeleteMapping("/delete/{id_user}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id_user) {
        userServiceImpl.DeleteUser(id_user);
        return ResponseEntity.ok("User deleted successfully");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addNewUser(@RequestBody User user) {
        userServiceImpl.AddNewUser(user);
        return ResponseEntity.ok("User added successfully");
    }

//    @PutMapping("/updateToken/{id_user}")
//    public ResponseEntity<String> updateUserToken(
//            @PathVariable Long id_user,
//            @RequestParam String token) {
//        userServiceImpl.UpdateUserToken(id_user, token);
//        return ResponseEntity.ok("User token updated successfully");
//    }

    @PutMapping("/updatePassword/{id_user}")
    public ResponseEntity<String> updateUserPassword(
            @PathVariable Long id_user,
            @RequestParam String mdp) {
        userServiceImpl.UpdateUserPassword(mdp, id_user);
        return ResponseEntity.ok("User password updated successfully");
    }
}
