package com.example.ecommerce_platform.entities;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id")
    private int Id;

    @Column(name = "role")
    private String role;


    public Role(int id, String role) {
        Id = id;
        this.role = role;
    }

    public Role(String role) {
        this.role = role;
    }

    public Role() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
