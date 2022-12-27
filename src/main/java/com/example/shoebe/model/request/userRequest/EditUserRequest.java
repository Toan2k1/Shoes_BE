package com.example.shoebe.model.request.userRequest;

import lombok.Data;

@Data
public class EditUserRequest {
    private Long id;
    private String username;
    private String password;
}
