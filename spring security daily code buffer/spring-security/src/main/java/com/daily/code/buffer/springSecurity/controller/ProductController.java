package com.daily.code.buffer.springSecurity.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private record Product(Integer productId, String productName, Double price) {
    }

    List<Product> products = new ArrayList<>(List.of(new Product(1, "iphone1", 10.00), new Product(2, "iphone2", 20.00)));

    @GetMapping("/all")
    public List<Product> getProducts(){
        return products;
    }

    @PostMapping("")
    public Product saveProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

}
