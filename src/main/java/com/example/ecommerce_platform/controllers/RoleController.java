package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.Role;
import com.example.ecommerce_platform.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController("role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping("list")
    public String listRole(Model model){
        String roleList=roleService.listRoles(model);
        return roleList;
    }
    @GetMapping("add")
    public Map<String, String> addRole(String role){
        Map<String, String> roles=roleService.addRole(role);
        return roles;
    }
}
