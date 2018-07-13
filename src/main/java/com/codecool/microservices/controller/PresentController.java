package com.codecool.microservices.controller;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class PresentController {

    @Autowired
    PresentService presentService;

    @GetMapping(value = "/getPresents")
    public ResponseEntity<List<Present>> getAllPresentByUserId(@SessionAttribute("user") User user){
        List<Present> presents = presentService.getPresentsByUserId(user.getId());
        if (presents != null) {
            return ResponseEntity.ok(presents);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/addNewPresent")
    public String renderForm(@SessionAttribute User user) {
        if (user.getId() != 0L) {
            return "presentForm";
        } else {
            return "redirect:/login";
        }
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
        if (user.getId() != 0L) {
            Present newPresent = new Present(name, description, price, category, true, (int) user.getId(), image, new Date());
            presentService.addPresent(newPresent);
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }
}
