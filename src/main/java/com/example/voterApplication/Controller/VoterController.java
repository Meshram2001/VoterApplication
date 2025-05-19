package com.example.voterApplication.Controller;

import com.example.voterApplication.DTO.UserAuthenticationDTO;
import com.example.voterApplication.Entity.UserAuthenticationEntity;
import com.example.voterApplication.Services.UserAuthenticationSer;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voter")
public class VoterController {

    private final UserAuthenticationSer userAuthenticationSer;

    public VoterController(UserAuthenticationSer userAuthenticationSer) {
        this.userAuthenticationSer = userAuthenticationSer;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody UserAuthenticationDTO userAuthDto, HttpServletRequest request) {

        System.out.println("Login attempt - Username: " + userAuthDto.getUsername());
        System.out.printf("Login attempt - password" + userAuthDto.getPassword());

        boolean isAuthenticated = userAuthenticationSer.Authentication(userAuthDto);

        if (isAuthenticated) {
            HttpSession session = request.getSession();
            session.setAttribute("username", userAuthDto.getUsername());
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(401).body("Authentication failed");
        }
    }


//    // New method to fetch all users
@GetMapping("/users")
public ResponseEntity<List<UserAuthenticationEntity>> getAllUsers() {
    List<UserAuthenticationEntity> users = userAuthenticationSer.getAllUsers();
    return ResponseEntity.ok(users);
}

}
