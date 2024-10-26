package com.francopaiz.financialManagementAPI.model.postgres;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Getter
@Data
@Entity
@Table(name = "users")
public class UserPostgres {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Setter
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Setter
    @Column(name = "phone")
    private String phone;


    public UserPostgres() {
    }

    public UserPostgres(Long id, String name, String email, String password, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
        this.phone = phone;
    }

    // Método para encriptar la contraseña usando BCrypt
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}