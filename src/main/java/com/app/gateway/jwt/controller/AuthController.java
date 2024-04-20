package com.app.gateway.jwt.controller;

import com.app.gateway.jwt.entity.UserInfo;
import com.app.gateway.jwt.repository.UserRepository;
import com.app.gateway.jwt.request.AuthRequestDTO;
import com.app.gateway.jwt.response.JwtResponseDTO;
import com.app.gateway.jwt.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public JwtResponseDTO AuthenticateAndGetToken(@RequestBody AuthRequestDTO authRequestDTO){
        Authentication authentication = authenticationProvider.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(), authRequestDTO.getPassword()));
        if(authentication.isAuthenticated()){
            UserInfo userDetails = userRepository.findByUsername(authRequestDTO.getUsername());
            return JwtResponseDTO.builder().accessToken(jwtService.generateToken(authRequestDTO.getUsername(),userDetails.getRoles())).build();
        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}
