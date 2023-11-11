package com.example.ecommerce_platform.exceptions;

import org.springframework.context.annotation.Bean;

public class alreadyExistsException extends RuntimeException {

        public alreadyExistsException(String message) {
            super(message);
        }

}
