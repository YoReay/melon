package com.yoreay.melon.product.controller;

import com.yoreay.melon.product.domain.Product;
import com.yoreay.melon.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product/{id}")
    Product info(@PathVariable("id") Long id) {
        return productService.getProductInfo(id);
    }

    @GetMapping(value = "/product/save")
    String save() {
        if (productService.addProduct("")) {
            return "success";
        }
        return "fail";
    }
}
