package com.javaproj.flipkart.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.javaproj.flipkart.dto.productDTO;
import com.javaproj.flipkart.model.Category;
import com.javaproj.flipkart.model.Product;
import com.javaproj.flipkart.model.Seller;
import com.javaproj.flipkart.service.CategoryService;
import com.javaproj.flipkart.service.ProductService;
import com.javaproj.flipkart.service.SellerService;

import org.springframework.ui.Model;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    SellerService sellerService;

    @GetMapping("/admin")
    public String adminHome() {
        return "adminHome";
    }

    @GetMapping("/admin/categories")
    public String getCat(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category", Category.getnewcat());
        return "categoriesAdd";
    }


    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/delete/{id}")
    public String deletecat(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/categories/update/{id}")
    public String updatecat(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesAdd";
        } else
            return "404";

    }

    @GetMapping("/admin/sellers")
    public String getSel(Model model) {
        model.addAttribute("sellers", sellerService.getAllSeller());
        return "sellers";
    }

    @GetMapping("/admin/sellers/add")
    public String getSelAdd(Model model) {
        model.addAttribute("sellers", new Seller());
        return "sellersAdd";
    }

    @PostMapping("/admin/sellers/add")
    public String postSelAdd(@ModelAttribute("seller") Seller seller) {
        sellerService.addSeller(seller);
        return "redirect:/admin/sellers";
    }

    @GetMapping("/admin/sellers/delete/{id}")
    public String deletesel(@PathVariable int id) {
        sellerService.deleteSellerById(id);
        return "redirect:/admin/sellers";
    }

    @GetMapping("/admin/sellers/update/{id}")
    public String updatesel(@PathVariable int id, Model model) {
        Optional<Seller> seller = sellerService.getSellerById(id);
        if (seller.isPresent()) {
            model.addAttribute("seller", seller.get());
            return "sellersAdd";
        } else
            return "404";

    }

    @GetMapping("/admin/products")
    public String getProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }

    @GetMapping("/admin/products/add")
    public String getProdAdd(Model model) {
        model.addAttribute("productDTO", new productDTO());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("sellers", sellerService.getAllSeller());
        return "productsAdd";
    }

    @PostMapping("/admin/products/add")
    public String postProdAdd(@ModelAttribute("productDTO") productDTO productDTO) {

        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setSeller(sellerService.getSellerById(productDTO.getSellerId()).get());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        productService.addProduct(product);

        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteprod(@PathVariable long id) {
        productService.deleteProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String updateprod(@PathVariable long id, Model model) {
        Product product = productService.getProductById(id).get();
        productDTO productDTO = new productDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        productDTO.setPrice(product.getPrice());
        productDTO.setSellerId(product.getSeller().getId());
        productDTO.setDescription(product.getDescription());

        model.addAttribute("productDTO", productDTO);
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("sellers", sellerService.getAllSeller());
        return "productsAdd";
    }

}
