package com.example.ecommerce_platform.repository;

import com.example.ecommerce_platform.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer > {

    Role findByRole(String role);
}
