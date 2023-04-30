package com.javaproj.flipkart.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.javaproj.flipkart.model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
