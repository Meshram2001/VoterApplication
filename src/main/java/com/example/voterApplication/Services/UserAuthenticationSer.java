package com.example.voterApplication.Services;

import com.example.voterApplication.DTO.UserAuthenticationDTO;
import com.example.voterApplication.Entity.UserAuthenticationEntity;

import java.util.List;

public interface UserAuthenticationSer {

    public boolean Authentication(UserAuthenticationDTO userAuthenticationDTO);


    String UserAuth(UserAuthenticationDTO userAuthenticationDTO) throws IllegalAccessException;

//    List<UserAuthenticationEntity> getAllUsers();
}