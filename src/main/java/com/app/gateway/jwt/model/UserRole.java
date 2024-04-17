package com.app.gateway.jwt.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class UserRole {
    private UUID id;
    private String name;

}
