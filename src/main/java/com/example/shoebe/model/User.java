package com.example.shoebe.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "`User`")
@Data
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;
    private String email;
    private boolean isDelete;

    public User() {
    }

    public User( String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;
    }
}


