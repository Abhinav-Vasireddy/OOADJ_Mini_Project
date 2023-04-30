package com.javaproj.flipkart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproj.flipkart.model.Product;
import com.javaproj.flipkart.repo.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public void addProduct(Product product) {
        productRepo.save(product);
    }

    public void deleteProductById(long id) {
        productRepo.deleteById(id);
    }

    public Optional<Product> getProductById(long id) {
        return productRepo.findById(id);
    }

    public List<Product> getProductsByCategory(int id) {
        return productRepo.findAllByCategoryId(id);
    }

    public List<Product> getProductsBySeller(int id) {
        return productRepo.findAllBySellerId(id);
    }
}
