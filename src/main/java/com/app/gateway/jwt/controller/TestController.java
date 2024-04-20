package com.app.gateway.jwt.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/test")
    public String test(){
        return "return from test";
    }
}
