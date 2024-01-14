package com.example.ecommerce_platform.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private OrderStatus status;


}
