package com.codecool.microservices.controller;


import com.codecool.microservices.model.User;
import com.codecool.microservices.model.Wallet;
import com.codecool.microservices.service.CommunicationService;
import com.codecool.microservices.service.UserService;
import com.codecool.microservices.service.WalletService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
@SessionAttributes({"user"})
public class UserController {

    private static final String loginHTML = "login";

    private UserService userService;
    private CommunicationService communicationService;
    private WalletService walletService;

    public UserController(UserService userService, CommunicationService communicationService, WalletService walletService) {
        this.userService = userService;
        this.communicationService = communicationService;
        this.walletService = walletService;
    }

    @ModelAttribute("user")
    public User setUpUser(){
        return null;
    }

    @GetMapping(value = "/login")
    public String displayLogin(@ModelAttribute("user") User user, Model model) {
        System.out.println(user);
        return loginHTML;
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("login_email") String email,
                        @RequestParam("login_password") String password,
                        Model model) {
        try {
            User user = userService.login(email);
            if (BCrypt.checkpw(password, user.getPassword())) {
                user.removePassword();
                user.login();
                model.addAttribute("user", user);
                return "redirect:/";
            } else {
                throw new AuthenticationException();
            }
        } catch (NullPointerException | AuthenticationException e) {
            System.out.println("Couldn't log in");
            return loginHTML;
        }
    }

    @PostMapping(value = "/registration")
    public String registration(@RequestParam("reg_email") String email,
                               @RequestParam("reg_password") String password,
                               @RequestParam("first_name") String firstName,
                               @RequestParam("last_name") String lastName,
                               @RequestParam("address") String address,
                               @RequestParam("phone_number") String phoneNumber, Model model){
        password = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            userService.registration(email, password, firstName, lastName, address, phoneNumber);
            User newUser = userService.createUser(firstName, lastName, email, address, phoneNumber);
            communicationService.sendRegistrationEmail(newUser);
            walletService.getWallet(newUser.getId());
        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
            model.addAttribute("error", "Couldn't register user!");
        }
        return loginHTML;
    }

    @GetMapping(value = "/logout")
    public String logout(@ModelAttribute User user, Model model, HttpServletRequest httpServletRequest){
        model.addAttribute("user", userService.getAnonymUser());
        return loginHTML;
    }

    @PostMapping("/user")
    public ResponseEntity<Map<String, Object>> getUserDetails(@ModelAttribute User user) {
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        Wallet wallet = walletService.getWallet(user.getId());
        Map<String, Object> wrapper = new LinkedHashMap<>();
        wrapper.put("user", user);
        wrapper.put("balance", wallet.getBalance());
        return ResponseEntity.ok(wrapper);
//        return ResponseEntity.ok(new User(1, "qwe", "qwe", "eqw", "eqw ", "eqw"));
    }
}
