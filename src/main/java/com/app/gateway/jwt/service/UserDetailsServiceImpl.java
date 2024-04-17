package com.app.gateway.jwt.service;

import com.app.gateway.jwt.model.CustomUserDetails;
import com.app.gateway.jwt.model.UserInfo;
import com.app.gateway.jwt.model.UserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Entering in loadUserByUsername Method...");
        UserInfo user = null;
        if(username.equalsIgnoreCase("aditya"))
            user = UserInfo.builder().id(UUID.randomUUID()).username("aditya").roles(new HashSet<>(Set.of(UserRole.builder().id(UUID.randomUUID()).name("ADMIN").build()))).build();
        if(user == null){
            logger.error("Username not found: " + username);
            throw new UsernameNotFoundException("could not found user..!!");
        }
        logger.info("User Authenticated Successfully..!!!");
        return new CustomUserDetails(user);
    }
}
