package com.springSecurity.spring_security.controller;

import com.springSecurity.spring_security.config.JWTService;
import com.springSecurity.spring_security.entity.OurteamEntity;
import com.springSecurity.spring_security.service.OurTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class OurTeamController {

    private OurTeamService ourTeamService;
    private JWTService jwtService;

    public OurTeamController(OurTeamService ourTeamService, JWTService jwtService) {
        this.ourTeamService = ourTeamService;
        this.jwtService = jwtService;
    }

    @GetMapping("/get-our-team")
    public List<OurteamEntity> getourteam(@RequestHeader("Authorization") String headers) {

        final String jwt = headers.substring(7);
        final String userName = jwtService.extractUserName(jwt);
        System.out.println("username: " + userName);

        return ourTeamService.getallourteam();
    }

    @PostMapping("/our-team-process")
    public String postData(@RequestBody OurteamEntity ourteamEntity) {
        return ourTeamService.postData(ourteamEntity);
    }

}
