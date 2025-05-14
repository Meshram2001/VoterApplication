package com.example.voterApplication.DTO;

import lombok.Data;

@Data
public class UserAuthenticationDTO {

    private  long id;

    private String username;

    private  String password;
}
