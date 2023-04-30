package com.javaproj.flipkart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproj.flipkart.model.Role;

public interface RoleRepo extends JpaRepository<Role,Integer> {
    
}
