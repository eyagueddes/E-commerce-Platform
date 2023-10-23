package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.repository.RoleRepository;
import com.example.ecommerce_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository,BCryptPasswordEncoder bCryptPasswordEncoder){
       this.roleRepository=roleRepository;
       this.userRepository=userRepository;
       this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }
    public User findUserByEmail(String email){
        return userRepository.findByEmail(email);

    }

    public User saveUser(User user){
        User u=null;
         u=userRepository.findByEmail(user.getEmail());
        if(u!=null){
            System.out.println("user exist");
        }
        else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(1);
            userRepository.save(user);
        }
        return user;
    }

}
