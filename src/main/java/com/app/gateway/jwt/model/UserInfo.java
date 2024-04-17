package com.app.gateway.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Builder
@Getter
@Setter
public class UserInfo {
    private UUID id;
    private String username;
    @JsonIgnore
    private String password;
    private Set<UserRole> roles;
}
