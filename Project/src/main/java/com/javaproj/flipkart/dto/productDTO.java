package com.javaproj.flipkart.dto;

import lombok.Data;

@Data
public class productDTO {
    private Long id;
    private String name;
    private int categoryId;
    private int sellerId;
    private double price;
    private String description;
}
