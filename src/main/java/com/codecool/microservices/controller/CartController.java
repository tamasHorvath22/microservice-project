package com.codecool.microservices.controller;

import com.codecool.microservices.model.Present;
import com.codecool.microservices.model.User;
import com.codecool.microservices.service.CartService;
import com.codecool.microservices.service.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
public class CartController {

    private final static String MAIN_PAGE = "index";
    private final static String CART_PAGE = "cart";

    @Autowired
    private CartService cartService;
    @Autowired
    private PresentService presentService;

    @GetMapping("/cart")
    public String showCart(@SessionAttribute("user") User user, Model model) {
        long userId = user.getId();
        List<Present> presents = cartService.getPresentsInCart(cartService.getCart(userId));
        model.addAttribute("presents", presents);
        model.addAttribute("sumPrice", cartService.getCartSumPrice(presents));
        model.addAttribute("user", user);
        return CART_PAGE;
    }

    @PostMapping("/cart")
    public String addToCart(@RequestParam("presentId") long presentId, @SessionAttribute("user") User user) throws ParseException {
        long userId = user.getId();
        Present modifiedPresent = presentService.getPresent(presentId);
        modifiedPresent.setAvailable(false);
        presentService.modifyPresent(presentId,modifiedPresent);
        cartService.addToCart(userId, presentId);
        return "redirect:/";
    }

    @DeleteMapping("/cart")
    public String removeFromCart(@RequestParam("presentId") long presentId,
                                 @SessionAttribute("user") User user) throws ParseException {
        long userId = user.getId();
        Present modifiedPresent = presentService.getPresent(presentId);
        modifiedPresent.setAvailable(true);
        presentService.modifyPresent(presentId,modifiedPresent);
        cartService.removeFromCart(userId, presentId);
        return CART_PAGE;
    }

}
