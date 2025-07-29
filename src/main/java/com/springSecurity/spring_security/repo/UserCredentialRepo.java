package com.springSecurity.spring_security.repo;

import com.springSecurity.spring_security.entity.UserCredentialEnitity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialRepo extends JpaRepository<UserCredentialEnitity, Long> {
    UserCredentialEnitity findByUsername(String username);
}
