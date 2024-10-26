package com.francopaiz.financialManagementAPI.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
public class User {

    @Setter
    @Id
    private String id;
    @Setter
    private String name;
    @Setter
    private String email;
    private String password;
    @Setter
    private String phone;

    public User() {
    }

    public User(String id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.phone = phone;
    }

    public void setPassword(String password) {
        // Aplicar cifrado de BCrypt siempre que se cambie la contraseña
        this.password = new BCryptPasswordEncoder().encode(password);
    }

}