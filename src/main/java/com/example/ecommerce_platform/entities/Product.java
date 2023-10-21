package com.example.ecommerce_platform.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity

public class Product {
    @NotBlank(message = "name is mandatory")
    String name;
    String description;
   double  price;
   int stock;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Product(String name, String description, double price, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
