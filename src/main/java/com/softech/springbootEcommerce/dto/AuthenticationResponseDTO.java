package com.softech.springbootEcommerce.dto;

public class AuthenticationResponseDTO {
    private final String token;

    public AuthenticationResponseDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
