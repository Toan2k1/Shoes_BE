package com.example.shoebe.model.request.userRequest;

import lombok.Data;

@Data
public class EditUserRequest {
    private long id;
    private String password;
    private String username;
    private String email;
}
