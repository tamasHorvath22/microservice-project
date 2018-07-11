package com.codecool.microservices.controller;


import com.codecool.microservices.service.CommunicationService;
import com.codecool.microservices.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class UserController {

    private static final String loginHTML = "login";

    private UserService userService;
    private CommunicationService communicationService;

    public UserController(UserService userService, CommunicationService communicationService){
        this.userService = userService;
        this.communicationService = communicationService;
    }

    @GetMapping(value = "/login")
    public String displayLogin(){
        return loginHTML;
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("login-username") String username,
                        @RequestParam("login-password") String password) {
        return "valami";
    }
}
