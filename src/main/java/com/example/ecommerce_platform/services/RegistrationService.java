package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.Role;
import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.repository.RoleRepository;
import com.example.ecommerce_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Arrays;
import java.util.HashSet;

@Service("registrationService")
public class RegistrationService {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    public User createNewUser(@RequestBody User user){
        User u =userService.findUserByEmail(user.getEmail());

        if(u!=null){
            System.out.println("user already exist");

        }
        else{
            Role userRole=roleRepository.findByRole(user.getTempRole());//check if role exist
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));

            userService.saveUser(user);

        }
        return user;

    }



}
