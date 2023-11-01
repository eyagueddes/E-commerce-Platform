package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {


    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value="/registration",method = RequestMethod.POST)
    private User registerUser(@RequestBody User user){

        return registrationService.createNewUser(user);
    }
}
