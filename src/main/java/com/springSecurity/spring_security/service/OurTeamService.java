package com.springSecurity.spring_security.service;

import com.springSecurity.spring_security.entity.OurteamEntity;
import com.springSecurity.spring_security.repo.OurTeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OurTeamService {

    @Autowired
    private OurTeamRepo ourTeamRepo;


    public List<OurteamEntity> getallourteam() {

//        String username=jwtService.extractUserName();
        return ourTeamRepo.findAll();
    }

    public String postData(OurteamEntity ourteamEntity) {
        ourTeamRepo.save(ourteamEntity);
        return "data Saved Successfully";
    }
}
