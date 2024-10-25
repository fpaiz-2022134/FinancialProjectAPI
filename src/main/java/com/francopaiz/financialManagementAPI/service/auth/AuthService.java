package com.francopaiz.financialManagementAPI.service.auth;
import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.repository.usuario.UserRepository;
import com.francopaiz.financialManagementAPI.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public String login(String email, String password) {
        // Validar credenciales nulas
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email and password cannot be null");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);

        // Verificar si el usuario existe
        User user = optionalUser.orElseThrow(() -> new RuntimeException("Invalid credentials"));

        // Comparar la contraseña ingresada con la almacenada
        if (passwordEncoder.matches(password, user.getPassword())) {
            return jwtTokenUtil.generateToken(user.getId());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}