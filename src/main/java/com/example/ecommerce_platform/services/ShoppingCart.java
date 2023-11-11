package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.Product;
import com.example.ecommerce_platform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service("/cartService")
public class ShoppingCart {

    private List<Optional<Product>> cartItems;


    @Autowired
    private ProductRepository productRepository;

    public ShoppingCart() {
        this.cartItems = new ArrayList<Optional<Product>>();
    }
    public void addToCart(Long idProduct){
        Optional<Product> product=productRepository.findById(idProduct);
        if(product.isPresent()){
            cartItems.add(product);
        }
        else {
            throw new RuntimeException("this product does not exist");
        }


    }
    public void removeFromCart(Long idProduct){
        Optional<Product> product=productRepository.findById(idProduct);

        if(product.isPresent()){
            cartItems.remove(product);
        }
        else {
            throw new RuntimeException("this product does not exist");

        }
    }
}
