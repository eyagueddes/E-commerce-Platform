package com.example.ecommerce_platform.services;

import com.example.ecommerce_platform.entities.Role;
import com.example.ecommerce_platform.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {


    @Autowired
    private  RoleRepository roleRepository;
    public  Map<String, String> addRole(@RequestParam("role") String role){
        Map<String, String> roles = new HashMap<>(); // Assuming roles are stored in memory
        Role r=new Role(role);
        Role RoleExist=null;
        RoleExist =roleRepository.findByRole(role);
        if(RoleExist==null){
           Role savedRole= roleRepository.save(r);
        }
        else{
            System.out.println("role exist");
        }

        roles.put( "Role" ,role); // Assuming roles are stored in memory
        return roles;
    }
    public String listRoles(Model model){
        List<Role> roles= (List<Role>) roleRepository.findAll();
        long nb=roleRepository.count();
        if(roles.size()==0)
            roles=null;

            model.addAttribute("roles",roles);
            model.addAttribute("nb",nb);

        return "role/listRoles";
    }

}
