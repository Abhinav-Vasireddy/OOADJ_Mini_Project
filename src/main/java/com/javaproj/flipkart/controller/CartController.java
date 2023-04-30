package com.javaproj.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.javaproj.flipkart.global.GlobalData;
import com.javaproj.flipkart.model.Product;
import com.javaproj.flipkart.service.ProductService;

@Controller
public class CartController {
    @Autowired
    ProductService productService;

    @GetMapping("/addToCart/{id}")
    public String addtocart(@PathVariable long id) {
        GlobalData.cart.add(productService.getProductById(id).get());
        return "redirect:/shop";
    }

    @GetMapping("/cart")
    public String getcart(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart", GlobalData.cart);
        return "cart";
    }

    @GetMapping("/cart/removeItem/{index}")
    public String removeitem(@PathVariable int index) {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Model model) {
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }

    @GetMapping("/checkout1")
    public String checkout1() {
        GlobalData.cart.clear();
        return "checkout1";
    }

}
