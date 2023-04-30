package com.javaproj.flipkart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproj.flipkart.model.Seller;
import com.javaproj.flipkart.repo.SellerRepo;

@Service
public class SellerService {
    @Autowired
    SellerRepo sellerRepo;

    public List<Seller> getAllSeller() {
        return sellerRepo.findAll();
    }

    public void addSeller(Seller seller) {
        sellerRepo.save(seller);
    }

    public void deleteSellerById(int id) {
        sellerRepo.deleteById(id);
    }

    public Optional<Seller> getSellerById(int id) {
        return sellerRepo.findById(id);
    }
}
