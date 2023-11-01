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
    public User createNewUser( User user){
        User u =userService.findUserByEmail(user.getEmail());

        if(u!=null){
            System.out.println("user already exist");

        }
        else{
            Role userRole=roleRepository.findByRole(user.getTempRole());//check if role exist
            user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));// this role is stored in a HashSet
            System.out.println(Arrays.asList(userRole));//[com.example.ecommerce_platform.entities.Role@683f1f4e]
            // Arrays.asList(userRole):This creates a List containing a single element, which is the userRole object.
            // In a typical Spring Security setup,a user can have multiple roles, but in this case, it appears that a user is being assigned a single role.
            userService.saveUser(user);

        }
        return user;

    }



}
