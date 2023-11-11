package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> cartItems;

    public ShoppingCart() {
        this.cartItems = new ArrayList<>();
    }
    public void addToCart(Product product){
        cartItems.add(product);

    }
    public void addFromCart(Product product){
        cartItems.remove(product);

    }
}
