package com.javaproj.flipkart.global;

import java.util.ArrayList;
import java.util.List;

import com.javaproj.flipkart.model.Product;

public class GlobalData {
    public static List<Product> cart;
    static { 
        cart = new ArrayList<Product>();
    }
}
