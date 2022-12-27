package com.example.shoebe.model.response;

import lombok.Data;

@Data
public class LoginResponse {
    private String accessToken;
    private String tokenType;

    public LoginResponse(String jwt) {
        this.accessToken = jwt;
        this.tokenType = "Bearer";
    }
}
