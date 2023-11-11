package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.exceptions.alreadyExistsException;
import com.example.ecommerce_platform.repository.RoleRepository;
import com.example.ecommerce_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        return userRepository.findByEmail(email).get();

    }

    public User saveUser(User user){

        Optional<User> userExist=userRepository.findByEmail(user.getEmail());
        if(userExist.isPresent()){
            // TODO: how to implement custom exception
            throw  new alreadyExistsException("user already exist");
        }
        else {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setActive(1);
            userRepository.save(user);
        }
        return user;
    }

}
