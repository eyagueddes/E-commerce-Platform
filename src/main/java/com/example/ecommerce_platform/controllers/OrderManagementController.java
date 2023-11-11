package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.Order;
import com.example.ecommerce_platform.entities.Product;
import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.services.OrderManagementService;
import com.example.ecommerce_platform.services.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderManagementController {

    @Autowired
    private OrderManagementService orderManagementService;

    @Autowired
    private ShoppingCart shoppingCart;


    @PostMapping("/addOrder")
    public Order createOrder(User user, List<Product> products) {

        Order order= orderManagementService.createOrder(user,products);
        return order;
    }
    @ResponseBody
    @PostMapping("/processOrder")
    public String processOrder(Order order){
         orderManagementService.processOrder(order);
        return "order processed";
    }
    @PostMapping("/processOrder")

    public Map<String,String> shipOrder(Order order){
        orderManagementService.shipOrder(order);
        Map<String,String> m = new HashMap<>();
        m.put("message","message");
        return m;
    }
    @PostMapping("/add/{id}")
    public void addToCart(@PathVariable Long idProduct ) {
        shoppingCart.addToCart(idProduct);
    }

    @DeleteMapping("/remove/{id}")
    public void  removeFromCart(@PathVariable Long idProduct ) {
        shoppingCart.removeFromCart(idProduct);
    }





}
