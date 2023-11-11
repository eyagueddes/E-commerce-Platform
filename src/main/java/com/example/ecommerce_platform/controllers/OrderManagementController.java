package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.Order;
import com.example.ecommerce_platform.entities.Product;
import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.services.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
public class OrderManagementController {

    @Autowired
    private OrderManagementService orderManagementService;


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
    @ResponseBody
    public String shipOrder(Order order){
        orderManagementService.shipOrder(order);
        return "order shipped";
    }

}
