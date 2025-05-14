package com.example.voterApplication.Services;

import com.example.voterApplication.DTO.UserAuthenticationDTO;
import com.example.voterApplication.Entity.UserAuthenticationEntity;
import com.example.voterApplication.Repository.UserAuthenticationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthenticationSerImp implements  UserAuthenticationSer{

    @Autowired
  private  UserAuthenticationRepo userAuthenticationRepo;

   public UserAuthenticationSerImp(UserAuthenticationRepo userAuthenticationRepo){

    this.userAuthenticationRepo=userAuthenticationRepo;

   }
   @Override
   public String UserAuth(UserAuthenticationDTO userAuthenticationDTO) throws IllegalAccessException {

        if (userAuthenticationRepo.existsByUsername(userAuthenticationDTO.getUsername())){
            throw new IllegalAccessException("User is already exist");
        }



       UserAuthenticationEntity userAuthenticationEntity =new UserAuthenticationEntity();
       userAuthenticationEntity.setUsername(userAuthenticationDTO.getUsername().trim());
       userAuthenticationEntity.setPassword(userAuthenticationDTO.getPassword().trim());



     return userAuthenticationEntity.getUsername();

   }

    @Override
    public boolean Authentication(UserAuthenticationDTO dto) {
        String username = dto.getUsername().trim();
        String password = dto.getPassword().trim();

        // Check if it's admin
        if ("admin".equals(username) && "password".equals(password)) {
            return true;
        }

        // Check user in DB
        if (userAuthenticationRepo.existsByUsername(username)) {
            UserAuthenticationEntity userAuthenticationEntity = userAuthenticationRepo.findByUsername(username);

            if (userAuthenticationEntity.getPassword().equals(password)) {
                return true; // valid login
            } else {
                return false; // password mismatch
            }
        }

        return false; // username not found
    }

    // Methode for fetching the all user data


//    @Override
//    public List<UserAuthenticationEntity> getAllUsers() {
//        return userAuthenticationRepo.findAll();
//    }


}
