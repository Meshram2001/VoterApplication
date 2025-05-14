package com.example.voterApplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/")
public class MainController {

    @GetMapping
    public String LoginPage() {
        return "LoginPage";
    }

    @GetMapping("/new")
    public  String NewUser(){
        return "NewUser";
    }






}
