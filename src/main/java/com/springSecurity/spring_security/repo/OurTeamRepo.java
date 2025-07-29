package com.springSecurity.spring_security.repo;

import com.springSecurity.spring_security.entity.OurteamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OurTeamRepo extends JpaRepository<OurteamEntity, Long> {
}
