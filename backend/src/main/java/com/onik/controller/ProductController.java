package com.onik.controller;

import com.onik.entity.Product;
import com.onik.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by onik on 1/7/17.
 */
@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public Collection<Product> get() {
        return productService.findAll();
    }

    @GetMapping("/{PRODUCT_NUMBER}")
    public  Product get(@PathVariable("PRODUCT_NUMBER") String PRODUCT_NUMBER) {
        return productService.findOne(PRODUCT_NUMBER);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete/{PRODUCT_NUMBER}")
    public boolean delete(@PathVariable("PRODUCT_NUMBER") String PRODUCT_NUMBER) {
        return productService.delete(PRODUCT_NUMBER);
    }
}
