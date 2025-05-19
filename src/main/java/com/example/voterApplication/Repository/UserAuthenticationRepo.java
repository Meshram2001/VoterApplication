package com.example.voterApplication.Repository;

import com.example.voterApplication.Entity.UserAuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAuthenticationRepo extends JpaRepository<UserAuthenticationEntity,Long> {

    boolean existsByUsername(String username);

    UserAuthenticationEntity findByUsername(String username);


    //To fetch the data from all the user

    List<UserAuthenticationEntity> findByusername(String username);
}
