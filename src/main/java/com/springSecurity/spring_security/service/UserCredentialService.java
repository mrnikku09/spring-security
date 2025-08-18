package com.springSecurity.spring_security.service;

import com.springSecurity.spring_security.config.JWTService;
import com.springSecurity.spring_security.entity.UserCredentialEnitity;
import com.springSecurity.spring_security.repo.UserCredentialRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCredentialService {



    private final UserCredentialRepo userCredentialRepo;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public UserCredentialService(PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JWTService jwtService, UserCredentialRepo userCredentialRepo) {
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userCredentialRepo = userCredentialRepo;
    }

    public List<UserCredentialEnitity> getalluser() {
        return userCredentialRepo.findAll();
    }

    public String verify(UserCredentialEnitity user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated()) {
            return jwtService.generatetocken(user);

        } else {
            return "FAul";
        }
    }


    public String addUser(UserCredentialEnitity data) {

        data.setPassword((passwordEncoder.encode(data.getPassword())));
        userCredentialRepo.save(data);
        return "saved";

    }
}
