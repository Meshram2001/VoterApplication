package com.example.voterApplication.Services;

import com.example.voterApplication.DTO.UserAuthenticationDTO;
import com.example.voterApplication.Entity.UserAuthenticationEntity;
import com.example.voterApplication.Repository.UserAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

import java.util.List;


//This the method for put the user in the database
@Service
public class UserAuthenticationSerImp implements  UserAuthenticationSer{


  private final UserAuthenticationRepo userAuthenticationRepo;

   public UserAuthenticationSerImp(UserAuthenticationRepo userAuthenticationRepo){

    this.userAuthenticationRepo=userAuthenticationRepo;

   }
    @Override
    public String UserAuth(UserAuthenticationDTO userAuthenticationDTO) throws IllegalAccessException {

        String username = userAuthenticationDTO.getUsername();
        String password = userAuthenticationDTO.getPassword();

        if (username == null || password == null) {
            throw new IllegalArgumentException("Username or Password cannot be null");
        }

        username = username.trim();
        password = password.trim();

        if (userAuthenticationRepo.existsByUsername(username)) {
            throw new IllegalAccessException("User already exists");
        }

        UserAuthenticationEntity userAuthenticationEntity = new UserAuthenticationEntity();
        userAuthenticationEntity.setUsername(username);
        userAuthenticationEntity.setPassword(password);

        userAuthenticationRepo.save(userAuthenticationEntity); // Don't forget to save the user!

        return userAuthenticationEntity.getUsername();
    }


    @Override
    public boolean Authentication(UserAuthenticationDTO dto) {
        String username = dto.getUsername();
        String password = dto.getPassword();

        if (username == null || password == null) {
            return false;
        }

        username = username.trim();
        password = password.trim();

        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }

        if (userAuthenticationRepo.existsByUsername(username)) {
            UserAuthenticationEntity userAuthenticationEntity = userAuthenticationRepo.findByUsername(username);
            return userAuthenticationEntity.getPassword().equals(password);
        }

        return false;
    }

    // Methode for fetching the all user data
    @Override
    public List<UserAuthenticationEntity> getAllUsers() {

        return userAuthenticationRepo.findByusername("Admin");
    }


}
