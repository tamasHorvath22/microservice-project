package com.codecool.microservices.controller;

import com.codecool.microservices.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String profileView(@SessionAttribute User user) {
        if (user.getId() != 0) {
            return "profile";
        } else {
            return "redirect:/login";
        }
    }
}
