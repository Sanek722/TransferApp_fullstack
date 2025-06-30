package com.example.Security_Servis.Service;

import lombok.AllArgsConstructor;



public class JwtResponse {
    public String token;

    public JwtResponse(String token) {
        this.token = token;
    }

}
