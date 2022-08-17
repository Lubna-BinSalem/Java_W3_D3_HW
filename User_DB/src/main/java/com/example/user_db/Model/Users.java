package com.example.user_db.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity @AllArgsConstructor @NoArgsConstructor @Data
public class Users {

    @NotNull(message = "id must not be null")
    @Id
    private Integer id;

    @NotEmpty(message = "username must not be empty")
    private String username;

    @NotEmpty(message = "password must not be empty")
    private String password;

    @NotEmpty(message = "email must not be empty")
    private String email;

    @NotEmpty(message = "role must not be empty")
    private String role;

    @NotEmpty(message = "joiningYear must not be empty")
    private String joiningYear;

    @NotEmpty(message = "age must not be empty")
    private String age;
}
