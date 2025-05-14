package com.example.voterApplication.Repository;

import com.example.voterApplication.Entity.UserAuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepo extends JpaRepository<UserAuthenticationEntity,Long> {

    boolean existsByUsername(String username);

    UserAuthenticationEntity findByUsername(String username);


    //To fetch the data from all the user

//    UserAuthenticationEntity findByAll(String username);
}
