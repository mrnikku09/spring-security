package com.springSecurity.spring_security.controller;


import com.springSecurity.spring_security.config.TokenBlacklistService;
import com.springSecurity.spring_security.entity.UserCredentialEnitity;
import com.springSecurity.spring_security.service.UserCredentialService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserCredentialController {

    @Autowired
    private UserCredentialService userCredentialService;

    @Autowired
    private TokenBlacklistService tokenBlacklistService;

    //    private final Set<String> tokenBlacklist = Collections.synchronizedSet(new HashSet<>());
    @GetMapping
    public List<UserCredentialEnitity> home(HttpServletRequest http) {
//        System.out.println("home");
        return userCredentialService.getalluser();
    }

    @PostMapping("/add-user")
    public String adduser(@RequestBody UserCredentialEnitity data) {
        System.out.println(data);

        return userCredentialService.addUser(data);
//        return "home page";
    }

    @PostMapping("/verify")
    public String verifyuser(@RequestBody UserCredentialEnitity userCredentialEnitity) {
        return userCredentialService.verify(userCredentialEnitity);
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logoutuser(@RequestHeader(value = "Authorization") String authHeader) {
        String token = authHeader.substring(7); // Remove "Bearer " prefix
        tokenBlacklistService.blacklistToken(token);
        return ResponseEntity.ok()
                .body(Map.of("message", "Logout successful"));

    }
}
