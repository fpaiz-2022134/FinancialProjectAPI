package com.francopaiz.financialManagementAPI.service.auth;

import com.francopaiz.financialManagementAPI.model.User;
import com.francopaiz.financialManagementAPI.repository.usuario.UserRepository;
import com.francopaiz.financialManagementAPI.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        System.out.println(password + "  /   "+ user.getPassword());
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            System.out.println(user);
            return jwtTokenUtil.generateToken(user.getId());
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }
}
