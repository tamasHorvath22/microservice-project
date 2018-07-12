package com.codecool.microservices.controller;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@RestController
public class PresentController {

    @Autowired
    PresentService presentService;

    @GetMapping(value = "/getPresents")
    public List<Present> getAllPresentByUserId(@SessionAttribute("user") User user){
        return presentService.getPresentsByUserId(user.getId());
    }
}
