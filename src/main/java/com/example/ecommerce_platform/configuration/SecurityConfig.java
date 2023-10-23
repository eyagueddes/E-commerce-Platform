package com.example.ecommerce_platform.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig {

   // a "bean" is a reusable software component that is managed and instantiated by the Spring container.
    //When you mark a method with @Bean, it tells Spring that this method will return an object that should be registered as a bean in the Spring application context.
    // The object returned by the method will be managed by the Spring container, and you can use it in other parts of your application.
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        return  bCryptPasswordEncoder;
    }

}

