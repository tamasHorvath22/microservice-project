package com.codecool.microservices.controller;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class PresentController {

    @Autowired
    PresentService presentService;

    @GetMapping(value = "/getPresents")
    public List<Present> getAllPresentByUserId(@SessionAttribute("user") User user){
        return presentService.getPresentsByUserId(user.getId());
    }

    @GetMapping("/addNewPresent")
    public String renderForm() {
        return "presentForm";
    }

    @PostMapping("addNewPresent")
    public String addNewPresent(
            @SessionAttribute User user,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam double price,
            @RequestParam String category,
            @RequestParam String image
    ) {
        Present newPresent = new Present(name, description, price, category, true, (int) user.getId(), image, new Date());
        presentService.addPresent(newPresent);
        return "redirect:/";
    }
}
