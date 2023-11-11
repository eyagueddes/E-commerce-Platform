package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.Order;
import com.example.ecommerce_platform.entities.OrderStatus;
import com.example.ecommerce_platform.entities.Product;
import com.example.ecommerce_platform.entities.User;
import com.example.ecommerce_platform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import java.util.List;
@Service("OrderManagementService")
public class OrderManagementService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(User user, List<Product> products) {
        Order order=new Order();
        order.setProducts(products);
        order.setUser(user);
        order.setStatus(OrderStatus.CART);
        // Save the order to a database or perform other necessary action
       orderRepository.save(order);
        return order;

    }

    public String processOrder(Order order) {
        order.setStatus(OrderStatus.PROCESSING);
        orderRepository.save(order);
        return "";

    }

    public String shipOrder(Order order) {
        order.setStatus(OrderStatus.SHIPPED);
        orderRepository.save(order);
        return "";
    }
}
