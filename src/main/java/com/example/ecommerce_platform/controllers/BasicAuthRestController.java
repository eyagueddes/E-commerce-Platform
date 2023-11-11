package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController()
@RequestMapping("/auth")
@EnableWebSecurity
//User Authentication
public class BasicAuthRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/basicauth")
    public String getCurrentUser() {
        System.out.println("getCurrentUser");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        User user=null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {

            // Retrieve the username from the Authentication object
            user = userService.findUserByEmail(authentication.getName());

            System.out.println("user" + user);
            return "Current User: " + user;
        }
        else {
            throw new RuntimeException("No User");

        }

    }
    @GetMapping("/test")
    public String test(){
        System.out.println("hello from before");
        return "hello from the app";
    }
}
