package com.springSecurity.spring_security.config;

import com.springSecurity.spring_security.entity.UserCredentialEnitity;
import com.springSecurity.spring_security.repo.UserCredentialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomeUserCredential implements UserDetailsService {

    @Autowired
    private UserCredentialRepo userCredentialRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserCredentialEnitity userdata = userCredentialRepo.findByUsername(username);
        if (userdata == null) {
            throw new UsernameNotFoundException("User Not Found");
        }

        return new User(userdata.getUsername(),
                userdata.getPassword(),
                List.of(new SimpleGrantedAuthority(userdata.getRole())));

    }
}
