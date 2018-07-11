package com.codecool.microservices.controller;


import com.codecool.microservices.model.User;
import com.codecool.microservices.service.CommunicationService;
import com.codecool.microservices.service.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute("user")
    public User setUpUser(){
        return null;
    }

    @GetMapping(value = "/login")
    public String displayLogin(@ModelAttribute("user") User user, Model model){
        System.out.println(user);
        user = new User(1, "l", "v", "4", "5", "g");
        model.addAttribute("user", user);
        return loginHTML;
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("login_email") String email,
                        @RequestParam("login_password") String password) {
        return loginHTML;
    }

    @PostMapping(value = "/registration")
    public String registration(@RequestParam("reg_email") String email,
                               @RequestParam("reg_password") String password,
                               @RequestParam("first_name") String firstName,
                               @RequestParam("last_name") String lastName,
                               @RequestParam("phone_number") String phoneNumber){
        return loginHTML;
    }

    @GetMapping(value = "/logout")
    public String logout(){
        return loginHTML;
    }
}
