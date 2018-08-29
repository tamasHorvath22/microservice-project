package com.codecool.microservices.controller;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.PresentService;
import com.codecool.microservices.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PresentService presentService;

    @Autowired
    private RestSignatureFilter restSignatureFilter;

    @Autowired
    private WishlistService wishlistService;

    @GetMapping({"", "index"})
    public String indexPage(@SessionAttribute("user") User user, Model model){
        System.out.println(user.getId());
        List<Present> presents = new ArrayList<>();
        List<Present> randomPresents = new ArrayList<>();
        if(user.getId() != 0L) {
            try {
                presents = presentService.getAllPresents();
                randomPresents = presentService.getFourRandomPresents();
            } catch (ParseException ex) {
                System.out.println("no presents :(");
            }
            model.addAttribute("presents", presents);
            model.addAttribute("user", user);
            model.addAttribute("randomPresents", randomPresents);
            return "index";
        } else {
            return "redirect:login";
        }
    }


    @GetMapping(value = "/contact")
    public String contactPage() {
        return "contact";
    }
}
