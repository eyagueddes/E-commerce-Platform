package com.example.ecommerce_platform.controllers;

import com.example.ecommerce_platform.entities.Role;
import com.example.ecommerce_platform.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    @GetMapping("list")
    public List<Role> listRole(Model model){
        List<Role> roleList=roleService.listRoles(model);
        return roleList;
    }
    @PostMapping("/add")
    public Map<String, String> addRole(@RequestParam("role") String role){
        Map<String, String> roles=roleService.addRole(role);
        return roles;
    }
}
