package com.javaproj.flipkart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproj.flipkart.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAllByCategoryId(int id);
    List<Product> findAllBySellerId(int id);
    
}
