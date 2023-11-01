package com.example.ecommerce_platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ECommercePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommercePlatformApplication.class, args);
    }

}
