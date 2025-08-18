package com.springSecurity.spring_security.controller;


import com.springSecurity.spring_security.config.JWTService;
import com.springSecurity.spring_security.entity.UserCredentialEnitity;
import com.springSecurity.spring_security.service.UserCredentialService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserCredentialController {

    private final UserCredentialService userCredentialService;
    private final JWTService jwtService;

    public UserCredentialController(UserCredentialService userCredentialService,JWTService jwtService){
        this.userCredentialService=userCredentialService;
        this.jwtService=jwtService;
    }

    @GetMapping
    public List<UserCredentialEnitity> home(HttpServletRequest http) {
        return userCredentialService.getalluser();
    }

    @PostMapping("/add-user")
    public String adduser(@RequestBody UserCredentialEnitity data) {
        System.out.println(data);

        return userCredentialService.addUser(data);
    }

    @GetMapping("/login")
    public String verifyuser(@RequestBody UserCredentialEnitity userCredentialEnitity) {
        return userCredentialService.verify(userCredentialEnitity);
    }

        @GetMapping("/logout")
    public ResponseEntity<?> logoutuser(@RequestHeader(value = "Authorization") String authHeader) {
        String token = authHeader.substring(7); // Remove "Bearer " prefix
            jwtService.blacklistToken(token);
        return ResponseEntity.ok()
                .body(Map.of("message", "Logout successful"));

    }
}
