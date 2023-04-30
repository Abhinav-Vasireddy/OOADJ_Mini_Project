package com.javaproj.flipkart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproj.flipkart.model.Seller;

public interface SellerRepo extends JpaRepository<Seller,Integer>{
    
}
