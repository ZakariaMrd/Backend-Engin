package com.example.backendengin.dtos;

import lombok.Data;

@Data

public class UserDTO {
    private Long id_user;
    private String login;
    private String mdp;
    private String email;
    private String role;

    public UserDTO(Long id_user, String login, String mdp, String role, String email) {
        this.id_user = id_user;
        this.login = login;
        this.mdp = mdp;
        this.email = email;
        this.role = role;
    }


}
