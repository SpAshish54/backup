package com.learnings.capstone.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learnings.capstone.exception.CatalogBusinessException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var myUserEntityOpt = userService.getByName(username);
        if (myUserEntityOpt.isEmpty()) {
            throw new CatalogBusinessException("No user found with username " + username);
        }
        var myUserEntity = myUserEntityOpt.get();

        
        String roleWithoutPrefix = myUserEntity.getRole().startsWith("ROLE_") ?
                myUserEntity.getRole().substring("ROLE_".length()) : myUserEntity.getRole();

        return User.withUsername(myUserEntity.getName())
                .password(myUserEntity.getPassword())
                .roles(roleWithoutPrefix) 
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
